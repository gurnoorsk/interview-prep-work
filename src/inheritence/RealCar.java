package inheritence;

public class RealCar extends FuelableCar{


    public String capacity(){
        return "1l";
    }

    public void fuel(){
        System.out.println("RealCar fuel");
    }
    public void run(){
        System.out.println("RealCar run");
    }

    public void brake(){
        System.out.println("RealCar brake");
    }




    public void print(){}
}
