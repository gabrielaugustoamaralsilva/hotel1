package hostel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;

public class rodar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       try {
           System.out.print("Room number:");
           int roomnumber = sc.nextInt();
           sc.nextLine();
           System.out.println("Checkin date (dd/MM/yyyy)");
           Date checkin = sdf.parse(sc.next());
           System.out.println("Checkout date (dd/MM/yyyy)");
           Date checkout = sdf.parse(sc.next());
           Reservation re = new Reservation(roomnumber, checkin, checkout);
           System.out.println(re);
           System.out.println();
           System.out.println("enter data to update reservation");
           checkin = sdf.parse(sc.next());
           System.out.println("Checkout date (dd/MM/yyyy)");
           checkout = sdf.parse(sc.next());
           re.updateDates(checkin, checkout);
           Date now = new Date();
           System.out.println(re);
       }catch (ParseException e){
           System.out.println("invalid date format");
       }
       catch (ModeException g ){
           System.out.println("reservation error:" + g.getMessage());
       }
       catch (RuntimeException e){
           System.out.println("unexpected error");
       }
    }
}
