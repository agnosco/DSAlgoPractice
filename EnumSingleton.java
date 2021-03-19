package practice;

public enum EnumSingleton {
    INSTANCE;

    public void printThis(String toPrint){
        System.out.println(toPrint);
    }
}
