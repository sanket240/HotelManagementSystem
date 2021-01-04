import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

public class HotelTest {
    @Test
    public void HotelWhenAddedShouldReturnTrue() {
        HotelReservationSystem h1=new HotelReservationSystem();
        boolean result,result2,result3;
        result=h1.addHotel("Lakewood",110);
        result2=h1.addHotel("Bridgewood",160);
        result3=h1.addHotel("Ridgewood",220);
        h1.print();
        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }
    @Test
    public void givenDateRange_whenSearchedHotel_shouldBeAbleToReturnCheapestHotel() throws ParseException {
        HotelReservationSystem h1=new HotelReservationSystem();
        h1.addHotel("Lakewood",110);
        h1.addHotel("Bridgewood",160);
        h1.addHotel("Ridgewood",220);
        Result cheapestHotel=h1.findCheapestHotel("24/12/1998","28/12/1998");
        Assert.assertEquals(cheapestHotel.getName(),"Lakewood");
        Assert.assertEquals(cheapestHotel.getRate(),110*4);
    }
    @Test
    public void hotelsWhenAddedShouldContainWeekendAndWeekdayRates()
    {
        boolean result,result2,result3;
        HotelReservationSystem h1=new HotelReservationSystem();
        result=h1.addHotelWeekdayWeekend("Lakewood",110,90);
        result2=h1.addHotelWeekdayWeekend("Bridgewood",150,50);
        result3=h1.addHotelWeekdayWeekend("Ridgewood",220,150);
        h1.print();
        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }
    @Test
    public void hotelsWhenAddedShouldContainRatings()
    {
        boolean result,result2,result3;
        HotelReservationSystem h1=new HotelReservationSystem();
        result=h1.addHotelBasedOnRatings("Lakewood",110,90,3);
        result2=h1.addHotelBasedOnRatings("Bridgewood",150,50,4);
        result3=h1.addHotelBasedOnRatings("Ridgewood",220,150,5);
        h1.print();
        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);

    }
    @Test
    public void givenDateRange_whenSearched_shouldReturnCheapestHotelBasedOnWeekdayAndWeekend() throws ParseException {
        HotelReservationSystem h1=new HotelReservationSystem();
        h1.addHotel("Lakewood",110);
        h1.addHotel("Bridgewood",160);
        h1.addHotel("Ridgewood",220);
        List<Result> cheapestHotelResult= h1.findCheapestHotelBasedOnDay("24/12/1998","28/12/1998");
        Assert.assertEquals(3,cheapestHotelResult.size());
    }
}