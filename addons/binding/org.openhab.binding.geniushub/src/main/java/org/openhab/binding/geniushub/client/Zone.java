package org.openhab.binding.geniushub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Zone {

    @SerializedName("iID")
    @Expose
    private Integer iID;
    @SerializedName("iType")
    @Expose
    private Integer iType;
    @SerializedName("zoneSubType")
    @Expose
    private Integer zoneSubType;
    @SerializedName("iFlags")
    @Expose
    private Integer iFlags;
    @SerializedName("iPriority")
    @Expose
    private Integer iPriority;
    @SerializedName("strName")
    @Expose
    private String strName;
    @SerializedName("iMode")
    @Expose
    private Integer iMode;
    @SerializedName("iBaseMode")
    @Expose
    private Integer iBaseMode;
    @SerializedName("iFlagExpectedKit")
    @Expose
    private Integer iFlagExpectedKit;
    @SerializedName("iFlagActualKit")
    @Expose
    private Integer iFlagActualKit;
    @SerializedName("iBoostTimeRemaining")
    @Expose
    private Integer iBoostTimeRemaining;
    @SerializedName("iOverrideMode")
    @Expose
    private Integer iOverrideMode;
    @SerializedName("iOverrideDuration")
    @Expose
    private Integer iOverrideDuration;
    @SerializedName("lOptions")
    @Expose
    private Integer lOptions;
    @SerializedName("bPrimaryZone")
    @Expose
    private Boolean bPrimaryZone;
    @SerializedName("fOutput")
    @Expose
    private Double fOutput;
    @SerializedName("bIsActive")
    @Expose
    private Boolean bIsActive;
    @SerializedName("lstIssues")
    @Expose
    private List<LstIssue> lstIssues = new ArrayList<LstIssue>();
    @SerializedName("datapoints")
    @Expose
    private List<Datapoint> datapoints = new ArrayList<Datapoint>();
    @SerializedName("bHeatEnabled")
    @Expose
    private Boolean bHeatEnabled;
    @SerializedName("fPV")
    @Expose
    private Double fPV;
    @SerializedName("strBuildDate")
    @Expose
    private String strBuildDate;
    @SerializedName("fExternalPV")
    @Expose
    private Double fExternalPV;
    @SerializedName("tmBoilerDaily")
    @Expose
    private Integer tmBoilerDaily;
    @SerializedName("tmBoilerWeekly")
    @Expose
    private Integer tmBoilerWeekly;
    @SerializedName("strTime")
    @Expose
    private String strTime;
    @SerializedName("weatherData")
    @Expose
    private WeatherData weatherData;
    @SerializedName("gasMeter")
    @Expose
    private GasMeter gasMeter;
    @SerializedName("mappings")
    @Expose
    private Mappings mappings;
    @SerializedName("fSP")
    @Expose
    private Double fSP;
    @SerializedName("fMinSP")
    @Expose
    private Double fMinSP;
    @SerializedName("fMaxSP")
    @Expose
    private Double fMaxSP;
    @SerializedName("fDeadbandHigh")
    @Expose
    private Double fDeadbandHigh;
    @SerializedName("fDeadbandLow")
    @Expose
    private Double fDeadbandLow;
    @SerializedName("fFrostSP")
    @Expose
    private Double fFrostSP;
    @SerializedName("fBoostSP")
    @Expose
    private Double fBoostSP;
    @SerializedName("iLogPeriod")
    @Expose
    private Integer iLogPeriod;
    @SerializedName("linkedSettings")
    @Expose
    private LinkedSettings linkedSettings;
    @SerializedName("warmupDuration")
    @Expose
    private WarmupDuration warmupDuration;
    @SerializedName("fPV_offset")
    @Expose
    private Double fPVOffset;
    @SerializedName("iActivity")
    @Expose
    private Integer iActivity;
    @SerializedName("bOutRequestHeat")
    @Expose
    private Boolean bOutRequestHeat;
    @SerializedName("bInHeatEnabled")
    @Expose
    private Boolean bInHeatEnabled;
    @SerializedName("bTriggerWarmup")
    @Expose
    private Boolean bTriggerWarmup;
    @SerializedName("tmMaxTimeAtSP")
    @Expose
    private Integer tmMaxTimeAtSP;
    @SerializedName("tmTimeAtSP")
    @Expose
    private Integer tmTimeAtSP;
    @SerializedName("lstNodes")
    @Expose
    private List<Object> lstNodes = new ArrayList<Object>();
    @SerializedName("zoneReactive")
    @Expose
    private ZoneReactive zoneReactive;

    public Integer getIID() {
        return iID;
    }

    public void setIID(Integer iID) {
        this.iID = iID;
    }

    public Integer getIType() {
        return iType;
    }

    public void setIType(Integer iType) {
        this.iType = iType;
    }

    public Integer getZoneSubType() {
        return zoneSubType;
    }

    public void setZoneSubType(Integer zoneSubType) {
        this.zoneSubType = zoneSubType;
    }

    public Integer getIFlags() {
        return iFlags;
    }

    public void setIFlags(Integer iFlags) {
        this.iFlags = iFlags;
    }

    public Integer getIPriority() {
        return iPriority;
    }

    public void setIPriority(Integer iPriority) {
        this.iPriority = iPriority;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Integer getIMode() {
        return iMode;
    }

    public void setIMode(Integer iMode) {
        this.iMode = iMode;
    }

    public Integer getIBaseMode() {
        return iBaseMode;
    }

    public void setIBaseMode(Integer iBaseMode) {
        this.iBaseMode = iBaseMode;
    }

    public Integer getIFlagExpectedKit() {
        return iFlagExpectedKit;
    }

    public void setIFlagExpectedKit(Integer iFlagExpectedKit) {
        this.iFlagExpectedKit = iFlagExpectedKit;
    }

    public Integer getIFlagActualKit() {
        return iFlagActualKit;
    }

    public void setIFlagActualKit(Integer iFlagActualKit) {
        this.iFlagActualKit = iFlagActualKit;
    }

    public Integer getIBoostTimeRemaining() {
        return iBoostTimeRemaining;
    }

    public void setIBoostTimeRemaining(Integer iBoostTimeRemaining) {
        this.iBoostTimeRemaining = iBoostTimeRemaining;
    }

    public Integer getIOverrideMode() {
        return iOverrideMode;
    }

    public void setIOverrideMode(Integer iOverrideMode) {
        this.iOverrideMode = iOverrideMode;
    }

    public Integer getIOverrideDuration() {
        return iOverrideDuration;
    }

    public void setIOverrideDuration(Integer iOverrideDuration) {
        this.iOverrideDuration = iOverrideDuration;
    }

    public Integer getLOptions() {
        return lOptions;
    }

    public void setLOptions(Integer lOptions) {
        this.lOptions = lOptions;
    }

    public Boolean getBPrimaryZone() {
        return bPrimaryZone;
    }

    public void setBPrimaryZone(Boolean bPrimaryZone) {
        this.bPrimaryZone = bPrimaryZone;
    }

    public Double getFOutput() {
        return fOutput;
    }

    public void setFOutput(Double fOutput) {
        this.fOutput = fOutput;
    }

    public Boolean getBIsActive() {
        return bIsActive;
    }

    public void setBIsActive(Boolean bIsActive) {
        this.bIsActive = bIsActive;
    }

    public List<LstIssue> getLstIssues() {
        return lstIssues;
    }

    public void setLstIssues(List<LstIssue> lstIssues) {
        this.lstIssues = lstIssues;
    }

    public List<Datapoint> getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(List<Datapoint> datapoints) {
        this.datapoints = datapoints;
    }

    public Boolean getBHeatEnabled() {
        return bHeatEnabled;
    }

    public void setBHeatEnabled(Boolean bHeatEnabled) {
        this.bHeatEnabled = bHeatEnabled;
    }

    public Double getFPV() {
        return fPV;
    }

    public void setFPV(Double fPV) {
        this.fPV = fPV;
    }

    public String getStrBuildDate() {
        return strBuildDate;
    }

    public void setStrBuildDate(String strBuildDate) {
        this.strBuildDate = strBuildDate;
    }

    public Double getFExternalPV() {
        return fExternalPV;
    }

    public void setFExternalPV(Double fExternalPV) {
        this.fExternalPV = fExternalPV;
    }

    public Integer getTmBoilerDaily() {
        return tmBoilerDaily;
    }

    public void setTmBoilerDaily(Integer tmBoilerDaily) {
        this.tmBoilerDaily = tmBoilerDaily;
    }

    public Integer getTmBoilerWeekly() {
        return tmBoilerWeekly;
    }

    public void setTmBoilerWeekly(Integer tmBoilerWeekly) {
        this.tmBoilerWeekly = tmBoilerWeekly;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public GasMeter getGasMeter() {
        return gasMeter;
    }

    public void setGasMeter(GasMeter gasMeter) {
        this.gasMeter = gasMeter;
    }

    public Mappings getMappings() {
        return mappings;
    }

    public void setMappings(Mappings mappings) {
        this.mappings = mappings;
    }

    public Double getFSP() {
        return fSP;
    }

    public void setFSP(Double fSP) {
        this.fSP = fSP;
    }

    public Double getFMinSP() {
        return fMinSP;
    }

    public void setFMinSP(Double fMinSP) {
        this.fMinSP = fMinSP;
    }

    public Double getFMaxSP() {
        return fMaxSP;
    }

    public void setFMaxSP(Double fMaxSP) {
        this.fMaxSP = fMaxSP;
    }

    public Double getFDeadbandHigh() {
        return fDeadbandHigh;
    }

    public void setFDeadbandHigh(Double fDeadbandHigh) {
        this.fDeadbandHigh = fDeadbandHigh;
    }

    public Double getFDeadbandLow() {
        return fDeadbandLow;
    }

    public void setFDeadbandLow(Double fDeadbandLow) {
        this.fDeadbandLow = fDeadbandLow;
    }

    public Double getFFrostSP() {
        return fFrostSP;
    }

    public void setFFrostSP(Double fFrostSP) {
        this.fFrostSP = fFrostSP;
    }

    public Double getFBoostSP() {
        return fBoostSP;
    }

    public void setFBoostSP(Double fBoostSP) {
        this.fBoostSP = fBoostSP;
    }

    public Integer getILogPeriod() {
        return iLogPeriod;
    }

    public void setILogPeriod(Integer iLogPeriod) {
        this.iLogPeriod = iLogPeriod;
    }

    public LinkedSettings getLinkedSettings() {
        return linkedSettings;
    }

    public void setLinkedSettings(LinkedSettings linkedSettings) {
        this.linkedSettings = linkedSettings;
    }

    public WarmupDuration getWarmupDuration() {
        return warmupDuration;
    }

    public void setWarmupDuration(WarmupDuration warmupDuration) {
        this.warmupDuration = warmupDuration;
    }

    public Double getFPVOffset() {
        return fPVOffset;
    }

    public void setFPVOffset(Double fPVOffset) {
        this.fPVOffset = fPVOffset;
    }

    public Integer getIActivity() {
        return iActivity;
    }

    public void setIActivity(Integer iActivity) {
        this.iActivity = iActivity;
    }

    public Boolean getBOutRequestHeat() {
        return bOutRequestHeat;
    }

    public void setBOutRequestHeat(Boolean bOutRequestHeat) {
        this.bOutRequestHeat = bOutRequestHeat;
    }

    public Boolean getBInHeatEnabled() {
        return bInHeatEnabled;
    }

    public void setBInHeatEnabled(Boolean bInHeatEnabled) {
        this.bInHeatEnabled = bInHeatEnabled;
    }

    public Boolean getBTriggerWarmup() {
        return bTriggerWarmup;
    }

    public void setBTriggerWarmup(Boolean bTriggerWarmup) {
        this.bTriggerWarmup = bTriggerWarmup;
    }

    public Integer getTmMaxTimeAtSP() {
        return tmMaxTimeAtSP;
    }

    public void setTmMaxTimeAtSP(Integer tmMaxTimeAtSP) {
        this.tmMaxTimeAtSP = tmMaxTimeAtSP;
    }

    public Integer getTmTimeAtSP() {
        return tmTimeAtSP;
    }

    public void setTmTimeAtSP(Integer tmTimeAtSP) {
        this.tmTimeAtSP = tmTimeAtSP;
    }

    public List<Object> getLstNodes() {
        return lstNodes;
    }

    public void setLstNodes(List<Object> lstNodes) {
        this.lstNodes = lstNodes;
    }

    public ZoneReactive getZoneReactive() {
        return zoneReactive;
    }

    public void setZoneReactive(ZoneReactive zoneReactive) {
        this.zoneReactive = zoneReactive;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] { "" });
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iID).append(iType).append(zoneSubType).append(iFlags).append(iPriority)
                .append(strName).append(iMode).append(iBaseMode).append(iFlagExpectedKit).append(iFlagActualKit)
                .append(iBoostTimeRemaining).append(iOverrideMode).append(iOverrideDuration).append(lOptions)
                .append(bPrimaryZone).append(fOutput).append(bIsActive).append(lstIssues).append(datapoints)
                .append(bHeatEnabled).append(fPV).append(strBuildDate).append(fExternalPV).append(tmBoilerDaily)
                .append(tmBoilerWeekly).append(strTime).append(weatherData).append(gasMeter).append(mappings)
                .append(fSP).append(fMinSP).append(fMaxSP).append(fDeadbandHigh).append(fDeadbandLow).append(fFrostSP)
                .append(fBoostSP).append(iLogPeriod).append(linkedSettings).append(warmupDuration).append(fPVOffset)
                .append(iActivity).append(bOutRequestHeat).append(bInHeatEnabled).append(bTriggerWarmup)
                .append(tmMaxTimeAtSP).append(tmTimeAtSP).append(lstNodes).append(zoneReactive).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Zone) == false) {
            return false;
        }
        Zone rhs = ((Zone) other);
        return new EqualsBuilder().append(iID, rhs.iID).append(iType, rhs.iType).append(zoneSubType, rhs.zoneSubType)
                .append(iFlags, rhs.iFlags).append(iPriority, rhs.iPriority).append(strName, rhs.strName)
                .append(iMode, rhs.iMode).append(iBaseMode, rhs.iBaseMode)
                .append(iFlagExpectedKit, rhs.iFlagExpectedKit).append(iFlagActualKit, rhs.iFlagActualKit)
                .append(iBoostTimeRemaining, rhs.iBoostTimeRemaining).append(iOverrideMode, rhs.iOverrideMode)
                .append(iOverrideDuration, rhs.iOverrideDuration).append(lOptions, rhs.lOptions)
                .append(bPrimaryZone, rhs.bPrimaryZone).append(fOutput, rhs.fOutput).append(bIsActive, rhs.bIsActive)
                .append(lstIssues, rhs.lstIssues).append(datapoints, rhs.datapoints)
                .append(bHeatEnabled, rhs.bHeatEnabled).append(fPV, rhs.fPV).append(strBuildDate, rhs.strBuildDate)
                .append(fExternalPV, rhs.fExternalPV).append(tmBoilerDaily, rhs.tmBoilerDaily)
                .append(tmBoilerWeekly, rhs.tmBoilerWeekly).append(strTime, rhs.strTime)
                .append(weatherData, rhs.weatherData).append(gasMeter, rhs.gasMeter).append(mappings, rhs.mappings)
                .append(fSP, rhs.fSP).append(fMinSP, rhs.fMinSP).append(fMaxSP, rhs.fMaxSP)
                .append(fDeadbandHigh, rhs.fDeadbandHigh).append(fDeadbandLow, rhs.fDeadbandLow)
                .append(fFrostSP, rhs.fFrostSP).append(fBoostSP, rhs.fBoostSP).append(iLogPeriod, rhs.iLogPeriod)
                .append(linkedSettings, rhs.linkedSettings).append(warmupDuration, rhs.warmupDuration)
                .append(fPVOffset, rhs.fPVOffset).append(iActivity, rhs.iActivity)
                .append(bOutRequestHeat, rhs.bOutRequestHeat).append(bInHeatEnabled, rhs.bInHeatEnabled)
                .append(bTriggerWarmup, rhs.bTriggerWarmup).append(tmMaxTimeAtSP, rhs.tmMaxTimeAtSP)
                .append(tmTimeAtSP, rhs.tmTimeAtSP).append(lstNodes, rhs.lstNodes)
                .append(zoneReactive, rhs.zoneReactive).isEquals();
    }

}
