package com.example.holideys.network.holidey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolyBaseResponce {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("warning")
    @Expose
    private String warning;
    @SerializedName("requests")
    @Expose
    private Requests requests;
    @SerializedName("holidays")
    @Expose
    private List<Holiday1> holidays = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public HolyBaseResponce() {
    }

    /**
     *
     * @param holidays
     * @param warning
     * @param requests
     * @param status
     */
    public HolyBaseResponce(Integer status, String warning, Requests requests, List<Holiday1> holidays) {
        super();
        this.status = status;
        this.warning = warning;
        this.requests = requests;
        this.holidays = holidays;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public List<Holiday1> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday1> holidays) {
        this.holidays = holidays;
    }

}