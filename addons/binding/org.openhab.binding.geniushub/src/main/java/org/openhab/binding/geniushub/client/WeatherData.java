package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("temperature")
    @Expose
    private Integer temperature;
    @SerializedName("uv")
    @Expose
    private Integer uv;
    @SerializedName("feels_like")
    @Expose
    private Integer feelsLike;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("weather_type")
    @Expose
    private Integer weatherType;
    @SerializedName("precipitation")
    @Expose
    private Integer precipitation;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(Integer weatherType) {
        this.weatherType = weatherType;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timestamp).append(temperature).append(uv).append(feelsLike).append(humidity)
                .append(weatherType).append(precipitation).append(status).append(message).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherData) == false) {
            return false;
        }
        WeatherData rhs = ((WeatherData) other);
        return new EqualsBuilder().append(timestamp, rhs.timestamp).append(temperature, rhs.temperature)
                .append(uv, rhs.uv).append(feelsLike, rhs.feelsLike).append(humidity, rhs.humidity)
                .append(weatherType, rhs.weatherType).append(precipitation, rhs.precipitation)
                .append(status, rhs.status).append(message, rhs.message).isEquals();
    }

}
