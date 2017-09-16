package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicationVersion {

    @SerializedName("addr")
    @Expose
    private String addr;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("lastUpdate")
    @Expose
    private Integer lastUpdate;
    @SerializedName("confirmedValue")
    @Expose
    private Boolean confirmedValue;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("val_pend")
    @Expose
    private String valPend;
    @SerializedName("val_prev")
    @Expose
    private String valPrev;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getConfirmedValue() {
        return confirmedValue;
    }

    public void setConfirmedValue(Boolean confirmedValue) {
        this.confirmedValue = confirmedValue;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getValPend() {
        return valPend;
    }

    public void setValPend(String valPend) {
        this.valPend = valPend;
    }

    public String getValPrev() {
        return valPrev;
    }

    public void setValPrev(String valPrev) {
        this.valPrev = valPrev;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addr).append(type).append(lastUpdate).append(confirmedValue).append(path)
                .append(val).append(valPend).append(valPrev).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicationVersion) == false) {
            return false;
        }
        ApplicationVersion rhs = ((ApplicationVersion) other);
        return new EqualsBuilder().append(addr, rhs.addr).append(type, rhs.type).append(lastUpdate, rhs.lastUpdate)
                .append(confirmedValue, rhs.confirmedValue).append(path, rhs.path).append(val, rhs.val)
                .append(valPend, rhs.valPend).append(valPrev, rhs.valPrev).isEquals();
    }

}
