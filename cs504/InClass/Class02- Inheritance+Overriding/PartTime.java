public class PartTime extends Employee {
    private int hour;
    private int rate;

    PartTime() {}

    PartTime(int hour, int rate) {
        this.hour = hour;
        this.rate = rate;
    }

    PartTime(String name, int hour, int rate) {
        setName(name);
        this.hour = hour;
        this.rate = rate;
    }

    public void setHour (int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setRate (int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public int pay() {
        return (hour*rate) + super.pay();
    }



}
