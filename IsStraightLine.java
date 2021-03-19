package practice;

public class IsStraightLine {
    public static void main(String[] args) {

        int[][]  coordinates = { {0,0}, {0,5}, {5,0} };
        System.out.println(checkStraightLine(coordinates));
    }
    public static boolean checkStraightLine(int[][] coordinates) {
        float slope = getSlope(coordinates[0], coordinates[1]);
        for(int i = 2;  i < coordinates.length; i++){
            if(slope != getSlope(coordinates[0], coordinates[i])){
                return false;
            }
        }

        return true;
    }

    private static float getSlope(int[] p1, int[] p2){
        if(p2[0] - p1[0] == 0) return 0;
        return (float)(p2[1] - p1[1])/(p2[0] - p1[0]);
    }
}
