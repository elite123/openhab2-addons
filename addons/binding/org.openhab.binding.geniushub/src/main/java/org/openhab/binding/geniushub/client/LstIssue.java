package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstIssue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(level).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LstIssue) == false) {
            return false;
        }
        LstIssue rhs = ((LstIssue) other);
        return new EqualsBuilder().append(id, rhs.id).append(level, rhs.level).append(data, rhs.data).isEquals();
    }

}
