package inheritence;

public interface IInterfaceB {

    default public void print(){
        System.out.println("iInterfaceB print");
    }

    public void apply();
}
