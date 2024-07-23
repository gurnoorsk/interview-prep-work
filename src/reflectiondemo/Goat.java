package reflectiondemo;

public class Goat extends Animal implements Locomotion{
    public Goat(String name) {
        super(name);
    }

    @Override
    public String eats() {
        return "grass";
    }

    @Override
    protected String getSound() {
        return "blehh";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }
}
