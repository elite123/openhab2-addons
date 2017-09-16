package org.openhab.binding.geniushub.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Client {
    // TODO:Catch 'X-Genius-ProxyLocation header and switch on redirect 308
    public final static String GENIUSHUB_URL = "https://hub-server-1.heatgenius.co.uk";
    private final static Logger logger = LoggerFactory.getLogger(Client.class);

    private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // print base64.b64encode(u+":"+hashlib.sha256("%s%s" %(u,p)).hexdigest())
    private String getAuthString() {
        String sig = this.username + ":" + DigestUtils.sha256Hex(String.format("%s%s", this.username, this.password));
        return "Basic " + Base64.getEncoder().encodeToString(sig.getBytes(StandardCharsets.UTF_8));
    }

    public boolean Auth() {
        return request("/v2/auth/test") != null;
    }

    public Zones getZones() {
        Zones zones = null;
        String responseBody = this.request("/v2/zones");
        if (responseBody != null) {

            JsonParser parser = new JsonParser();

            JsonObject o = parser.parse(responseBody).getAsJsonObject();

            JsonArray rooms = o.getAsJsonArray("data");

            for (int i = 0; i < rooms.size(); i++) {
                JsonElement item = rooms.get(i);
                JsonObject obj1 = item.getAsJsonObject();
                obj1.remove("nodes");
                obj1.remove("objTimer");
                obj1.remove("objFootprint");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            logger.debug(gson.toJson(o));
            zones = gson.fromJson(responseBody, Zones.class);

        }
        return zones;
    }

    private synchronized String request(String path) {
        HttpClient client = new HttpClient();

        OptionsMethod method = new OptionsMethod(GENIUSHUB_URL + path);

        try {
            method.addRequestHeader(new Header("Accept", "*/*"));
            method.addRequestHeader(new Header("Access-Control-Request-Headers", "authorization"));
            method.addRequestHeader(new Header("Access-Control-Request-Method", "GET"));
            method.addRequestHeader(new Header("Connection", "keep-alive"));

            int statusCode;
            try {
                statusCode = client.executeMethod(method);
                if (statusCode >= HttpStatus.SC_BAD_REQUEST) {
                    logger.debug("OptionsMethod" + method.getStatusLine());
                    return null;
                }
            } catch (IOException e) {
                logger.error("OptionsMethod", e);
                return null;
            }

            String responseBody;
            try {
                responseBody = IOUtils.toString(method.getResponseBodyAsStream());
                if (!responseBody.isEmpty()) {
                    logger.debug("Body of response: " + responseBody.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("OptionsMethodBody", e);
                return null;
            }
        } finally {
            method.releaseConnection();
        }

        GetMethod get = new GetMethod(GENIUSHUB_URL + path);
        try {
            get.addRequestHeader(new Header("Accept", "application/json, text/javascript, */*; q=0.01"));
            get.addRequestHeader(new Header("Origin", "http://www.heatgenius.co.uk/app"));
            get.addRequestHeader(new Header("Connection", "keep-alive"));
            // Weird Auth thing!
            get.addRequestHeader(new Header("Authorization", this.getAuthString()));

            int statusCode;
            try {
                statusCode = client.executeMethod(get);
                if (statusCode >= HttpStatus.SC_BAD_REQUEST) {
                    logger.debug("GetMethod" + get.getStatusLine());
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("GetMethod", e);
                return null;
            }

            String responseBody = "";
            try {
                responseBody = IOUtils.toString(get.getResponseBodyAsStream());
                if (!responseBody.isEmpty()) {
                    logger.debug("Body of response: " + responseBody.toString());

                }

            } catch (IOException e) {
                e.printStackTrace();
                logger.error("GetMethodBody", e);
                return null;
            }

            return responseBody;
        } finally {
            get.releaseConnection();
        }

    }

}
