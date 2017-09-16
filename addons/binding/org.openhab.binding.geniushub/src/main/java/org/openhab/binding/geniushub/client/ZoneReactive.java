package org.openhab.binding.geniushub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZoneReactive {

    @SerializedName("iReactiveMinutesTriggerOn")
    @Expose
    private Integer iReactiveMinutesTriggerOn;
    @SerializedName("iReactiveMinutesTriggerOff")
    @Expose
    private Integer iReactiveMinutesTriggerOff;
    @SerializedName("fActivityLevel")
    @Expose
    private Double fActivityLevel;
    @SerializedName("fOnThreshold")
    @Expose
    private Double fOnThreshold;
    @SerializedName("fOffThreshold")
    @Expose
    private Double fOffThreshold;
    @SerializedName("bTriggerOn")
    @Expose
    private Boolean bTriggerOn;
    @SerializedName("bTriggerOff")
    @Expose
    private Boolean bTriggerOff;
    @SerializedName("iSensitivity")
    @Expose
    private Integer iSensitivity;
    @SerializedName("lstBufferOn")
    @Expose
    private List<Integer> lstBufferOn = new ArrayList<Integer>();
    @SerializedName("lstBufferOff")
    @Expose
    private List<Integer> lstBufferOff = new ArrayList<Integer>();
    @SerializedName("iTimeTillOn")
    @Expose
    private Integer iTimeTillOn;
    @SerializedName("iTimeTillOff")
    @Expose
    private Integer iTimeTillOff;

    public Integer getIReactiveMinutesTriggerOn() {
        return iReactiveMinutesTriggerOn;
    }

    public void setIReactiveMinutesTriggerOn(Integer iReactiveMinutesTriggerOn) {
        this.iReactiveMinutesTriggerOn = iReactiveMinutesTriggerOn;
    }

    public Integer getIReactiveMinutesTriggerOff() {
        return iReactiveMinutesTriggerOff;
    }

    public void setIReactiveMinutesTriggerOff(Integer iReactiveMinutesTriggerOff) {
        this.iReactiveMinutesTriggerOff = iReactiveMinutesTriggerOff;
    }

    public Double getFActivityLevel() {
        return fActivityLevel;
    }

    public void setFActivityLevel(Double fActivityLevel) {
        this.fActivityLevel = fActivityLevel;
    }

    public Double getFOnThreshold() {
        return fOnThreshold;
    }

    public void setFOnThreshold(Double fOnThreshold) {
        this.fOnThreshold = fOnThreshold;
    }

    public Double getFOffThreshold() {
        return fOffThreshold;
    }

    public void setFOffThreshold(Double fOffThreshold) {
        this.fOffThreshold = fOffThreshold;
    }

    public Boolean getBTriggerOn() {
        return bTriggerOn;
    }

    public void setBTriggerOn(Boolean bTriggerOn) {
        this.bTriggerOn = bTriggerOn;
    }

    public Boolean getBTriggerOff() {
        return bTriggerOff;
    }

    public void setBTriggerOff(Boolean bTriggerOff) {
        this.bTriggerOff = bTriggerOff;
    }

    public Integer getISensitivity() {
        return iSensitivity;
    }

    public void setISensitivity(Integer iSensitivity) {
        this.iSensitivity = iSensitivity;
    }

    public List<Integer> getLstBufferOn() {
        return lstBufferOn;
    }

    public void setLstBufferOn(List<Integer> lstBufferOn) {
        this.lstBufferOn = lstBufferOn;
    }

    public List<Integer> getLstBufferOff() {
        return lstBufferOff;
    }

    public void setLstBufferOff(List<Integer> lstBufferOff) {
        this.lstBufferOff = lstBufferOff;
    }

    public Integer getITimeTillOn() {
        return iTimeTillOn;
    }

    public void setITimeTillOn(Integer iTimeTillOn) {
        this.iTimeTillOn = iTimeTillOn;
    }

    public Integer getITimeTillOff() {
        return iTimeTillOff;
    }

    public void setITimeTillOff(Integer iTimeTillOff) {
        this.iTimeTillOff = iTimeTillOff;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iReactiveMinutesTriggerOn).append(iReactiveMinutesTriggerOff)
                .append(fActivityLevel).append(fOnThreshold).append(fOffThreshold).append(bTriggerOn)
                .append(bTriggerOff).append(iSensitivity).append(lstBufferOn).append(lstBufferOff).append(iTimeTillOn)
                .append(iTimeTillOff).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ZoneReactive) == false) {
            return false;
        }
        ZoneReactive rhs = ((ZoneReactive) other);
        return new EqualsBuilder().append(iReactiveMinutesTriggerOn, rhs.iReactiveMinutesTriggerOn)
                .append(iReactiveMinutesTriggerOff, rhs.iReactiveMinutesTriggerOff)
                .append(fActivityLevel, rhs.fActivityLevel).append(fOnThreshold, rhs.fOnThreshold)
                .append(fOffThreshold, rhs.fOffThreshold).append(bTriggerOn, rhs.bTriggerOn)
                .append(bTriggerOff, rhs.bTriggerOff).append(iSensitivity, rhs.iSensitivity)
                .append(lstBufferOn, rhs.lstBufferOn).append(lstBufferOff, rhs.lstBufferOff)
                .append(iTimeTillOn, rhs.iTimeTillOn).append(iTimeTillOff, rhs.iTimeTillOff).isEquals();
    }

}
