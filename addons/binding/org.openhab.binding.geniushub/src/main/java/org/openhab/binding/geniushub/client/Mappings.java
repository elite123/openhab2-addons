package org.openhab.binding.geniushub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mappings {

    @SerializedName("0")
    @Expose
    private List<String> _0 = new ArrayList<String>();
    @SerializedName("1")
    @Expose
    private List<String> _1 = new ArrayList<String>();
    @SerializedName("2")
    @Expose
    private List<String> _2 = new ArrayList<String>();
    @SerializedName("3")
    @Expose
    private List<String> _3 = new ArrayList<String>();
    @SerializedName("4")
    @Expose
    private List<String> _4 = new ArrayList<String>();
    @SerializedName("5")
    @Expose
    private List<String> _5 = new ArrayList<String>();
    @SerializedName("6")
    @Expose
    private List<String> _6 = new ArrayList<String>();
    @SerializedName("7")
    @Expose
    private List<String> _7 = new ArrayList<String>();
    @SerializedName("9")
    @Expose
    private List<String> _9 = new ArrayList<String>();
    @SerializedName("10")
    @Expose
    private List<String> _10 = new ArrayList<String>();

    public List<String> get0() {
        return _0;
    }

    public void set0(List<String> _0) {
        this._0 = _0;
    }

    public List<String> get1() {
        return _1;
    }

    public void set1(List<String> _1) {
        this._1 = _1;
    }

    public List<String> get2() {
        return _2;
    }

    public void set2(List<String> _2) {
        this._2 = _2;
    }

    public List<String> get3() {
        return _3;
    }

    public void set3(List<String> _3) {
        this._3 = _3;
    }

    public List<String> get4() {
        return _4;
    }

    public void set4(List<String> _4) {
        this._4 = _4;
    }

    public List<String> get5() {
        return _5;
    }

    public void set5(List<String> _5) {
        this._5 = _5;
    }

    public List<String> get6() {
        return _6;
    }

    public void set6(List<String> _6) {
        this._6 = _6;
    }

    public List<String> get7() {
        return _7;
    }

    public void set7(List<String> _7) {
        this._7 = _7;
    }

    public List<String> get9() {
        return _9;
    }

    public void set9(List<String> _9) {
        this._9 = _9;
    }

    public List<String> get10() {
        return _10;
    }

    public void set10(List<String> _10) {
        this._10 = _10;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_0).append(_1).append(_2).append(_3).append(_4).append(_5).append(_6)
                .append(_7).append(_9).append(_10).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Mappings) == false) {
            return false;
        }
        Mappings rhs = ((Mappings) other);
        return new EqualsBuilder().append(_0, rhs._0).append(_1, rhs._1).append(_2, rhs._2).append(_3, rhs._3)
                .append(_4, rhs._4).append(_5, rhs._5).append(_6, rhs._6).append(_7, rhs._7).append(_9, rhs._9)
                .append(_10, rhs._10).isEquals();
    }

}
