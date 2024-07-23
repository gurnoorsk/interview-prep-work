package inheritence;

public interface IInterfaceA {

    default public void print(){
        System.out.println("iInterfaceA print");
    }

    static public void staticPrint(){
        System.out.println("static iInterfaceA print");
    }

    public void apply();

    public void accept();


}
