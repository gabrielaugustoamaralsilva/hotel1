package hostel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;

public class rodar {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Room number:");
        int roomnumber = sc.nextInt();
        sc.nextLine();

           System.out.println("Checkin date (dd/MM/yyyy)");
           Date checkin = sdf.parse(sc.next());
           System.out.println("Checkout date (dd/MM/yyyy)");
           Date checkout = sdf.parse(sc.next());
           Reservation re = new Reservation(roomnumber, checkin, checkout);


          if (!checkout.after(checkin)){
              System.out.println("Error you cant use a date before the dat you enter here");
          }else  System.out.println(re);

    }
}
