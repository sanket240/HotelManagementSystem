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
    public String toString() {
        return
                "\n HotelName='" + name + '\'' +
                        ", Weekend rates'" +  weekendRate + '\''+
                        ", Weekday rates'" +weekdayRate+ '\''
                ;
    }
}
