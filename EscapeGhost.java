package practice;

public class EscapeGhost {
    public static void main(String[] args) {
        new EscapeGhost().escapeGhosts(new int[][]{{1,0},{0,3}}, new int[]{0,1});
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = getDistance(new int[]{0,0},target);
        for(int i = 0; i < ghosts.length; i++){
            if(getDistance(ghosts[i], target) <= myDist){
                return false;
            }
        }

        return true;
    }

    public int getDistance(int[] point, int[] target){
        return Math.abs(point[0] - target[0]) + Math.abs(point[1] - target[1]);
    }
}
