package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WarmupDuration {

    @SerializedName("iLagTime")
    @Expose
    private Integer iLagTime;
    @SerializedName("iRiseTime")
    @Expose
    private Integer iRiseTime;
    @SerializedName("iTotalTime")
    @Expose
    private Integer iTotalTime;
    @SerializedName("fRiseRate")
    @Expose
    private Double fRiseRate;
    @SerializedName("bEnable")
    @Expose
    private Boolean bEnable;
    @SerializedName("bEnableCalcs")
    @Expose
    private Boolean bEnableCalcs;

    public Integer getILagTime() {
        return iLagTime;
    }

    public void setILagTime(Integer iLagTime) {
        this.iLagTime = iLagTime;
    }

    public Integer getIRiseTime() {
        return iRiseTime;
    }

    public void setIRiseTime(Integer iRiseTime) {
        this.iRiseTime = iRiseTime;
    }

    public Integer getITotalTime() {
        return iTotalTime;
    }

    public void setITotalTime(Integer iTotalTime) {
        this.iTotalTime = iTotalTime;
    }

    public Double getFRiseRate() {
        return fRiseRate;
    }

    public void setFRiseRate(Double fRiseRate) {
        this.fRiseRate = fRiseRate;
    }

    public Boolean getBEnable() {
        return bEnable;
    }

    public void setBEnable(Boolean bEnable) {
        this.bEnable = bEnable;
    }

    public Boolean getBEnableCalcs() {
        return bEnableCalcs;
    }

    public void setBEnableCalcs(Boolean bEnableCalcs) {
        this.bEnableCalcs = bEnableCalcs;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iLagTime).append(iRiseTime).append(iTotalTime).append(fRiseRate)
                .append(bEnable).append(bEnableCalcs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WarmupDuration) == false) {
            return false;
        }
        WarmupDuration rhs = ((WarmupDuration) other);
        return new EqualsBuilder().append(iLagTime, rhs.iLagTime).append(iRiseTime, rhs.iRiseTime)
                .append(iTotalTime, rhs.iTotalTime).append(fRiseRate, rhs.fRiseRate).append(bEnable, rhs.bEnable)
                .append(bEnableCalcs, rhs.bEnableCalcs).isEquals();
    }

}
