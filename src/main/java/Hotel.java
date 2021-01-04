public class Hotel {
    int ratesForRegularCustomer;
    String name;
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
                        ", Rate for regular customer'" + ratesForRegularCustomer + '\''
                ;
    }
}
