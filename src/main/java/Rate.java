public class Rate implements Comparable{
    public Integer weekendRate;
    public Integer weekdayRate;
    public Integer getWeekendRate() {
        return weekendRate;
    }
    public void setWeekendRate(Integer weekendRate) {
        this.weekendRate = weekendRate;
    }
    public Integer getWeekdayRate() {
        return weekdayRate;
    }
    public void setWeekdayRate(Integer weekdayRate) {
        this.weekdayRate = weekdayRate;
    }
    @Override
    public int compareTo(Object o) {
        Rate otherObject =(Rate) o;
        return this.weekdayRate.compareTo(otherObject.getWeekdayRate());
    }
}
