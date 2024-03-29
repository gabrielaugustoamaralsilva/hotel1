package hostel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation{
  private Integer roomNumber;
 private Date checkin;
  private Date checkout;
private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(Integer roomNumber, Date checkin, Date checkout){
        if (checkin.after(checkout)){
            throw new ModeException("Reservation dates for update must be future dates");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public void  updateDates(Date checkin, Date checkout){
        Date now = new Date();
        if (checkin.after(checkout)){
            throw new ModeException("Reservation dates for update must be future dates");
        } else if (checkin.before(now) || checkout.before(now)) {
            throw new ModeException("check out date must be after check in date");
        }else {
            this.checkin = checkin;
            this.checkout = checkout;
        }
    }
    @Override
    public   String toString(){
        return "Room " + getRoomNumber() + ", chekin: " + sdf.format(getCheckin()) + " ,  chekout: " + sdf.format(getCheckout()) +", duration: " + duration() + " nights";
    }

}
