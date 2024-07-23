public interface FunctionInterfaceDemo {
    void get1();

    //void get5();

    default void get2(){
        System.out.println("Interface get2");
    }

    default void get3(){
        System.out.println("Interface get3");
    }

    static void get4(){
        System.out.println("Interface get4");
    }
}
