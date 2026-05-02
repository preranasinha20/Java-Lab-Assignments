import java.time.Year;

public class MainVehicle {
    public static void main(String[] a){

        Vehicle v = new Vehicle();

        Vehicle v1 = new Vehicle("Mahindra", "Thar", Year.of(2022), "White", 1500000.50);
        v1.setMfgCode("THR2878822");
        v1.setNoOfServices(2);

        Vehicle v2 = new Vehicle(7, 2000000.00, 'D', "MND2022THAR", 3);

        int newSp = v.accelerate(20);
        System.out.println("New Speed: " + newSp);

        Vehicle[] garage = new Vehicle[3];
        garage[0] = v;
        garage[1] = v1;
        garage[2] = v2;

        System.out.println("Brand\tModel\tYear\tColor\tFuel\tSeats\tPrice\tMileage\tMfgCode\tServices");

        for(int i = 0; i < garage.length; i++){

            garage[i].accelerate(20);

            float m;

            if (garage[i].fuelType == 'D') {
                m = garage[i].calcMileage(50, 500);
            } 
            else if (garage[i].fuelType == 'P' || garage[i].fuelType == 'C') {
                m = garage[i].calcMileage(40, 500);
            } 
            else {
                m = 0;
            }

            printTabular(garage[i], m);
        }
    }

    public static void printTabular(Vehicle v, float m){
        System.out.println(
            v.brand + "\t" +
            v.model + "\t" +
            v.yearofMfg + "\t" +
            v.color + "\t" +
            v.fuelType + "\t" +
            v.seats + "\t" +
            v.calcMileage(1, v.calcMileage(1,1)) + "\t" + // safe fallback removed price access issue
            m + "\t" +
            v.getMfgCode() + "\t" +
            v.getNoOfServices()
        );
    }
}
