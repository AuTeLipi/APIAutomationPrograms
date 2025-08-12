package com.LipiAutomation.Ex_07_Payload_management.Class.manualWay.requestPOJO;

import com.LipiAutomation.Ex_07_Payload_management.Class.tools.requestPojos.Bookingdates;

public class Booking {

    /*
    Response Body:
    {
    "firstname" : "NarayanaLipi",
    "lastname" : "Dubbaka",
    "totalprice" : 350,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2025-07-25",
        "checkout" : "2025-07-26"
    },
    "additionalneeds" : "Breakfast"
    }

     */

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private  boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
