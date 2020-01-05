package com.example.holideys.network.holidey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Holiday1 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("observed")
    @Expose
    private String observed;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("weekday")
    @Expose
    private Weekday weekday;

    /**
     * No args constructor for use in serialization
     *
     */
    public Holiday1() {
    }

    /**
     *
     * @param date
     * @param country
     * @param _public
     * @param name
     * @param weekday
     * @param uuid
     * @param observed
     */
    public Holiday1(String name, String date, String observed, Boolean _public, String country, String uuid, Weekday weekday) {
        super();
        this.name = name;
        this.date = date;
        this.observed = observed;
        this._public = _public;
        this.country = country;
        this.uuid = uuid;
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

}