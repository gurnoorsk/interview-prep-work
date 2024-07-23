package reflectiondemo;

public abstract class Animal implements Eating {
    public static final String CATEGORY = "Domestic";
    private String name;

    protected abstract String getSound();

    public Animal(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
