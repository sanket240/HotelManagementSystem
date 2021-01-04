import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public boolean addHotelWeekdayWeekend(String hotelName,int weekEndRate,int weekDayRate)
    {
        Hotel hotel1=new Hotel();
        hotel1.name=hotelName;
        hotel1.weekdayRate=weekDayRate;
        hotel1.weekendRate=weekDayRate;
        hotel.add(hotel1);
        return true;
    }
    public Result findCheapestHotel(String initialDateRange,String endDateRange) throws ParseException
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBefore = myFormat.parse(initialDateRange);
        Date dateAfter = myFormat.parse(endDateRange);
        long difference = dateAfter.getTime() - dateBefore.getTime();
        float daysBetween = (difference / (1000*60*60*24));
        System.out.println(daysBetween);
        int a=Math.round(daysBetween);
        Hotel cheapestHotel= hotel.stream().min(Comparator.comparing(Hotel::getRatesForRegularCustomer)).orElseThrow(NoSuchElementException::new);
        Result result =new Result();
        result.setName(cheapestHotel.getName());
        result.setRate(cheapestHotel.getRatesForRegularCustomer()*a);
        return result;
    }
    public void print()
    {
        for (Hotel h : hotel)
        {
            System.out.println(h);
        }
    }
}
