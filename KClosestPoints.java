package practice;

import java.util.*;
import java.util.stream.Collectors;

public class KClosestPoints {

    public static class Pair<T, E> {
        T key;
        E value;

        public Pair(T key, E value) {
            this.key = key;
            this.value = value;
        }

        public static <T, E> Pair<T, E> of(T t, E e) {
            return new Pair(t, e);
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private double getDistance() {
            return Math.sqrt(x * x + y * y);
        }
    }

    public static void main(String[] args) {
        int[][] value = new KClosestPoints().getClosetPoints(new int[][]{{1,2}, {-2,-2}, {1, 1}}, 2);
        for (int[] aVal : value) {
            System.out.println(Arrays.toString(aVal));
        }
    }

    public int[][] getClosetPoints(int[][] ints, int k) {
        List<Point> points = new ArrayList<>();

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(point -> point.getDistance()));
        for (int i=0; i<ints.length; i++) {
            pq.add(new Point(ints[i][0], ints[i][1]));
        }

        int count = 0;
        while (count < k && pq.size() > 0){
             points.add(pq.peek());

        }

        return (int[][]) points.toArray();
//
//
//
//        List<Point> retPoints = points.stream()
//            .map(point -> Pair.of(point, point.getDistance()))
//            .sorted(Comparator.comparing(p -> p.getValue()))
//            .limit(k)
//            .map(p -> p.getKey())
//            .collect(Collectors.toList());
//
//        int[][] retVal = new int[retPoints.size()][2];
//        int i = 0;
//        for (Point p : retPoints) {
//            retVal[i][0] = p.x;
//            retVal[i][1] = p.y;
//            i++;
//        }
//
//        return  retVal;
    }

}


