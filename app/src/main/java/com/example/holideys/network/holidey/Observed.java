package com.example.holideys.network.holidey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Observed {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numeric")
    @Expose
    private String numeric;

    /**
     * No args constructor for use in serialization
     *
     */
    public Observed() {
    }

    /**
     *
     * @param name
     * @param numeric
     */
    public Observed(String name, String numeric) {
        super();
        this.name = name;
        this.numeric = numeric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }

}