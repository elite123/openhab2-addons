package org.openhab.binding.geniushub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkedSettings {

    @SerializedName("fLinkSP")
    @Expose
    private Double fLinkSP;
    @SerializedName("bFollowActive")
    @Expose
    private Boolean bFollowActive;
    @SerializedName("bFollowOutput")
    @Expose
    private Boolean bFollowOutput;
    @SerializedName("lstLinkedTo")
    @Expose
    private List<Integer> lstLinkedTo = new ArrayList<Integer>();

    public Double getFLinkSP() {
        return fLinkSP;
    }

    public void setFLinkSP(Double fLinkSP) {
        this.fLinkSP = fLinkSP;
    }

    public Boolean getBFollowActive() {
        return bFollowActive;
    }

    public void setBFollowActive(Boolean bFollowActive) {
        this.bFollowActive = bFollowActive;
    }

    public Boolean getBFollowOutput() {
        return bFollowOutput;
    }

    public void setBFollowOutput(Boolean bFollowOutput) {
        this.bFollowOutput = bFollowOutput;
    }

    public List<Integer> getLstLinkedTo() {
        return lstLinkedTo;
    }

    public void setLstLinkedTo(List<Integer> lstLinkedTo) {
        this.lstLinkedTo = lstLinkedTo;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fLinkSP).append(bFollowActive).append(bFollowOutput).append(lstLinkedTo)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LinkedSettings) == false) {
            return false;
        }
        LinkedSettings rhs = ((LinkedSettings) other);
        return new EqualsBuilder().append(fLinkSP, rhs.fLinkSP).append(bFollowActive, rhs.bFollowActive)
                .append(bFollowOutput, rhs.bFollowOutput).append(lstLinkedTo, rhs.lstLinkedTo).isEquals();
    }

}
