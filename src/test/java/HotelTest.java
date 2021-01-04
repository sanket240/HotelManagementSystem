import org.junit.Assert;
import org.junit.Test;
public class HotelTest {
    @Test
    public void HotelWhenAddedShouldReturnTrue() {
        HotelReservationSystem h1=new HotelReservationSystem();
        boolean result,result2,result3;
        result=h1.addHotel("Lakewood",110);
        result2=h1.addHotel("Bridgewood",150);
        result3=h1.addHotel("Ridgewood",220);
        h1.print();
        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }
}