public class Car {
    private String vehicle_id;
    private int speed;

    Car() {
        vehicle_id = "";
        speed = 0;
    }

    Car(String id, int spd) {
        vehicle_id = id;
        speed = spd;
    }

    public void setSpeed (int spd) {
        speed = spd;
    }

    public int getSpeed () {
        return speed;
    }

    public void setVehicleId (String id) {
        vehicle_id = id;
    }

    public String getVehicleId () {
        return vehicle_id;
    }
}
