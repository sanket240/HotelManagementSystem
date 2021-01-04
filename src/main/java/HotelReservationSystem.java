import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    public boolean addHotelBasedOnRatings(String hotelName,int weekEndRate,int weekDayRate,int rating)
    {
        Hotel hotel1=new Hotel();
        hotel1.name=hotelName;
        hotel1.weekdayRate=weekDayRate;
        hotel1.weekendRate=weekDayRate;
        hotel1.ratings=rating;
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
    public List<Result> findCheapestHotelBasedOnDay(String initialDateRange,String endDateRange) throws ParseException
    {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBefore = myFormat.parse(initialDateRange);
        Date dateAfter = myFormat.parse(endDateRange);
        long difference = dateAfter.getTime() - dateBefore.getTime();
        float daysBetween = (difference / (1000*60*60*24));
        System.out.println(daysBetween);
        int a=Math.round(daysBetween);
        List<Result> results= (List<Result>) hotel.stream().map(hotel1 -> {
            Result result =new Result();
            result.setName(hotel1.getName());
            try {
                result.setRate(hotel1.getTotalRates(initialDateRange,endDateRange));
            } catch (ParseException e) {
                e.printStackTrace();
            }return  result;
        }).sorted(Comparator.comparing(Result::getRate)).collect(Collectors.toList());
        return results.stream().filter(result -> result.getRate()==results.get(0).getRate()).collect(Collectors.toList());
    }
    public List<Result> findCheapestHotelBasedOnDayRating(String initialDateRange,String endDateRange) throws ParseException
    {
        List<Result> results= (List<Result>) this.hotel.stream().map(hotel1 -> {
            Result result=new Result();
            result.setName(hotel1.getName());
            try {
                result.setRate(hotel1.getTotalRates(initialDateRange,endDateRange));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result.setRating(hotel1.getRatings());
            return result;
        }).sorted(Comparator.comparing(Result::getRating).thenComparing(Result::getRating,Comparator.reverseOrder())).collect(Collectors.toList());
        return results.stream().filter(result -> result.getRating()==results.get(0).getRating()).collect(Collectors.toList());
    }
}
