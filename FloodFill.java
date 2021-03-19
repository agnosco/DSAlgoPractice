package practice;

public class FloodFill {
    public static void main(String[] args) {
        floodFill(new int[10][10], 2, 2, 2);
    }

    public static  int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int orgColor = image[sr][sc];
        if(orgColor == newColor){
            return image;
        }
        for (int r = 0; r < image.length; r++){
            for (int c = 0; c < image[r].length; c++) {
                if(!isVisited()){

                }
            }
        }

        return image;

    }

    private static boolean isVisited(){
        return true;
    }

}
