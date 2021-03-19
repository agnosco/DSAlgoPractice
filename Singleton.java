package practice;


public final class Singleton {

    private static  Singleton singleton = new Singleton();
    private Singleton(){
    }

    public static Singleton getInstance(){
       return singleton;
    }

    public void printThis(String str) {
        System.out.println(str);
    }
}
