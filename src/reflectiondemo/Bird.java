package reflectiondemo;

public class Bird extends Animal implements Locomotion{
    Boolean walks;
    public Bird(String name) {
        super(name);
        walks = false;
    }
    public Bird(String name,Boolean walks) {
        super(name);
        this.walks = walks;
    }

    @Override
    protected String getSound() {
        return "quak";
    }

    @Override
    public String eats() {
        return "grains";
    }

    @Override
    public String getLocomotion() {
        return walks?"walks":"flys";
    }
}
