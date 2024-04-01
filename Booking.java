package HotelReservation;

class Booking {
    private int bookingId;
    private Room room;
    private String guestName;
    private String startDate;
    private String endDate;
    private double totalPrice;

    public Booking(int bookingId, Room room, String guestName, String startDate, String endDate, double totalPrice) {
        this.bookingId = bookingId;
        this.room = room;
        this.guestName = guestName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
