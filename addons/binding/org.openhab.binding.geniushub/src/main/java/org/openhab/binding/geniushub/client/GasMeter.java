package org.openhab.binding.geniushub.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GasMeter {

    @SerializedName("iHealth")
    @Expose
    private Integer iHealth;

    public Integer getIHealth() {
        return iHealth;
    }

    public void setIHealth(Integer iHealth) {
        this.iHealth = iHealth;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iHealth).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GasMeter) == false) {
            return false;
        }
        GasMeter rhs = ((GasMeter) other);
        return new EqualsBuilder().append(iHealth, rhs.iHealth).isEquals();
    }

}
