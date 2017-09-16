package org.openhab.binding.geniushub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Zones {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("tm")
    @Expose
    private String tm;
    @SerializedName("data")
    @Expose
    private List<Zone> data = new ArrayList<Zone>();

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public List<Zone> getData() {
        return data;
    }

    public void setData(List<Zone> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(error).append(ts).append(tm).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Zones) == false) {
            return false;
        }
        Zones rhs = ((Zones) other);
        return new EqualsBuilder().append(error, rhs.error).append(ts, rhs.ts).append(tm, rhs.tm).append(data, rhs.data)
                .isEquals();
    }

}
