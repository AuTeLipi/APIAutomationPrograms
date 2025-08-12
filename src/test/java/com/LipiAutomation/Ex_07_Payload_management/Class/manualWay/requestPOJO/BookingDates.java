package com.LipiAutomation.Ex_07_Payload_management.Class.manualWay.requestPOJO;

public class BookingDates {

    /*
    "bookingdates" : {
        "checkin" : "2025-07-25",
        "checkout" : "2025-07-26"
    }
     */

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
