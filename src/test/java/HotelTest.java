import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

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
}