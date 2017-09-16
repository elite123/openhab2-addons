package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("nodeHash")
    @Expose
    private String nodeHash;
    @SerializedName("nodeID")
    @Expose
    private String nodeID;
    @SerializedName("batteryLevel")
    @Expose
    private Integer batteryLevel;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNodeHash() {
        return nodeHash;
    }

    public void setNodeHash(String nodeHash) {
        this.nodeHash = nodeHash;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(location).append(nodeHash).append(nodeID).append(batteryLevel).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(location, rhs.location).append(nodeHash, rhs.nodeHash)
                .append(nodeID, rhs.nodeID).append(batteryLevel, rhs.batteryLevel).isEquals();
    }

}
