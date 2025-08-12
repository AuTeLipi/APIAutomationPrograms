package com.LipiAutomation.Ex_07_Payload_management.Class.manualWay.responsePOJO;

import com.LipiAutomation.Ex_07_Payload_management.Class.manualWay.requestPOJO.Booking;
import com.LipiAutomation.Ex_07_Payload_management.Class.manualWay.requestPOJO.BookingDates;

public class BookingResponse {

    /*
    {
    "bookingid": 54230,
    "booking": {
        "firstname": "NarayanaLipi",
        "lastname": "Dubbaka",
        "totalprice": 350,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2025-07-25",
            "checkout": "2025-07-26"
        },
        "additionalneeds": "Breakfast"
    }
    }

     */

    // bookingid + (Booking - from requestPOJO)
    // Booking contains (Booking + bookingdates)

    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
