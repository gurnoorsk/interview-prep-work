public class SingletonHighradius {

    private static  SingletonHighradius  instance = null;

    static class InnerSingletonHighradius{
        public static SingletonHighradius instance = new SingletonHighradius();
    }

    public static SingletonHighradius getInstance(){
//        if(instance == null){
//            instance = new SingletonHighradius();
//        }
//        return instance;
        return InnerSingletonHighradius.instance;
    }

    private SingletonHighradius(){

    }



}
