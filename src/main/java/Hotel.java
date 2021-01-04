import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    int ratesForRegularCustomer;
    int weekendRate;
    int weekdayRate;
    String name;
    public int getWeekendRate() {
        return weekendRate;
    }
    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRatesForRegularCustomer() {
        return ratesForRegularCustomer;
    }
    public void setRatesForRegularCustomer(int ratesForRegularCustomer) {
        this.ratesForRegularCustomer = ratesForRegularCustomer;
    }
    public int getTotalRates(String initialDateRange,String endDateRange) throws ParseException
    {
        int rate;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBefore = myFormat.parse(initialDateRange);
        Date dateAfter = myFormat.parse(endDateRange);
        long difference = dateAfter.getTime() - dateBefore.getTime();
        float daysBetween = (difference / (1000*60*60*24));
        System.out.println(daysBetween);
        int a=Math.round(daysBetween);
        rate=((weekdayRate+weekendRate)/2)*a;
        return rate;
    }
    public String toString() {
        return
                "\n HotelName='" + name + '\'' +
                        ", Weekend rates'" +  weekendRate + '\''+
                        ", Weekday rates'" +weekdayRate+ '\''
                ;
    }
}
