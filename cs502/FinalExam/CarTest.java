public class CarTest {
    public static void main(String[] args) {
        String id = "LT5950";
        Car car1 = new Car();
        car1.setVehicleId(id);
        System.out.println("Car1 ID = " + car1.getVehicleId());

        Car honda = new Car(id, 55);
        honda.setSpeed(100);
        System.out.println("Honda speed = " + honda.getSpeed());
    }
}
