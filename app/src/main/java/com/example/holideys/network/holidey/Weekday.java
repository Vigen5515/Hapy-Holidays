package com.example.holideys.network.holidey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday {

    @SerializedName("date")
    @Expose
    private Date date;
    @SerializedName("observed")
    @Expose
    private Observed observed;

    /**
     * No args constructor for use in serialization
     *
     */
    public Weekday() {
    }

    /**
     *
     * @param date
     * @param observed
     */
    public Weekday(Date date, Observed observed) {
        super();
        this.date = date;
        this.observed = observed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Observed getObserved() {
        return observed;
    }

    public void setObserved(Observed observed) {
        this.observed = observed;
    }

}