import java.util.*;

public class HotelReservationSystem {
    ArrayList<Hotel> hotel=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public boolean addHotel(String hotelName,int rateForRegularCustomer)
    {
        Hotel hotel1=new Hotel();
        hotel1.name=hotelName;
        hotel1.ratesForRegularCustomer=rateForRegularCustomer;
        hotel.add(hotel1);
        System.out.println("Hotel Added");
        return true;
    }
    public void print()
    {
        for (Hotel h : hotel)
        {
            System.out.println(h);
        }
    }

}
