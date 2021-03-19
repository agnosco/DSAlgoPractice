package practice;

public class StealHouse {
    public static void main(String[] args) {
        System.out.println(stealHighNextHouse(new int[]{8,15,2,12,16,10}, 0));
    }

    static int stealHighNextHouse(int[] houseValues, int index) {

        if(index >= houseValues.length){
            return  0;
        }

        return Math.max(stealHighNextHouse(houseValues, index + 1),
                stealHighNextHouse(houseValues, index + 2) + houseValues[index]);
    }
}
