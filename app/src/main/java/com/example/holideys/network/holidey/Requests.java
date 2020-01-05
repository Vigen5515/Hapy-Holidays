package com.example.holideys.network.holidey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requests {

    @SerializedName("used")
    @Expose
    private Integer used;
    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("resets")
    @Expose
    private String resets;

    /**
     * No args constructor for use in serialization
     *
     */
    public Requests() {
    }

    /**
     *
     * @param available
     * @param resets
     * @param used
     */
    public Requests(Integer used, Integer available, String resets) {
        super();
        this.used = used;
        this.available = available;
        this.resets = resets;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getResets() {
        return resets;
    }

    public void setResets(String resets) {
        this.resets = resets;
    }

}