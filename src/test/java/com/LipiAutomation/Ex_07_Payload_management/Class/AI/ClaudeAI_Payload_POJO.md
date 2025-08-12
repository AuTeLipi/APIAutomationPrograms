
Content is user-generated and unverified.
4
// Main Request Payload class
public class RequestPayload {
private String firstname;
private String lastname;
private int totalprice;
private boolean depositpaid;
private BookingDates bookingdates;
private String additionalneeds;

    // Default constructor
    public RequestPayload() {}
    
    // Constructor with all fields
    public RequestPayload(String firstname, String lastname, int totalprice, 
                         boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
    
    // Getters
    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public int getTotalprice() {
        return totalprice;
    }
    
    public boolean isDepositpaid() {
        return depositpaid;
    }
    
    public BookingDates getBookingdates() {
        return bookingdates;
    }
    
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    
    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    
    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
    
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    
    @Override
    public String toString() {
        return "RequestPayload{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}

// Response class
public class Response {
private int bookingid;
private Booking booking;

    // Default constructor
    public Response() {}
    
    // Constructor with all fields
    public Response(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }
    
    // Getters
    public int getBookingid() {
        return bookingid;
    }
    
    public Booking getBooking() {
        return booking;
    }
    
    // Setters
    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }
    
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
    @Override
    public String toString() {
        return "Response{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}

// Booking class (same structure as RequestPayload but renamed for clarity)
public class Booking {
private String firstname;
private String lastname;
private int totalprice;
private boolean depositpaid;
private BookingDates bookingdates;
private String additionalneeds;

    // Default constructor
    public Booking() {}
    
    // Constructor with all fields
    public Booking(String firstname, String lastname, int totalprice, 
                   boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
    
    // Getters
    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public int getTotalprice() {
        return totalprice;
    }
    
    public boolean isDepositpaid() {
        return depositpaid;
    }
    
    public BookingDates getBookingdates() {
        return bookingdates;
    }
    
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    
    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    
    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
    
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    
    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}

// Nested BookingDates class
class BookingDates {
private String checkin;
private String checkout;

    // Default constructor
    public BookingDates() {}
    
    // Constructor with all fields
    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    
    // Getters
    public String getCheckin() {
        return checkin;
    }
    
    public String getCheckout() {
        return checkout;
    }
    
    // Setters
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    
    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
