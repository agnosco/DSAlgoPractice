package practice;

import com.sun.imageio.plugins.common.I18N;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

//@SpringBootApplication
public class SchoolApplication<S> {
    Stack<Integer> stack = new Stack<>();
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        if(A.size() > 0){
            ArrayList<Integer> G = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(A.get(0));
            G.add(-1);
            for(int i = 1; i < A.size(); i++){
                int flag = 0;
                Stack<Integer> tempStack = new Stack<>();
                tempStack.push(A.get(i));
                while(!stack.isEmpty() && stack.peek() > A.get(i)){
                    G.add(stack.peek());
                    tempStack.push(stack.peek());
                    stack.pop();
                    flag = 1;
                    break;
                }

                while (!tempStack.isEmpty()){
                    stack.push(tempStack.pop());
                }
                if(flag == 0){
                    G.add(-1);
                }
            }
            return G;
        }else{
            return new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) {
      
        
        
        
//		String a = Base64.getEncoder().encodeToString("hello".getBytes("ascii"));
//        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
//        System.out.println(knight(8, 8, 1, 1, 8, 8));
//        simplifyPath("/a/.//b/../../c/");
//        simplifyPath("/cbj/vfb/dyj/../../hjq/./unc/./cmv/./axj/../pzg/svs/oja/./rlc/vyr/cqq/../omk/viy/kyb/../ygr/mbx/nom/yvh/./../././lyg/qjv/./lwm/.././.././xga/krs/../xkl/wtj/nml/dal/hat/alw/jvo/./../xts/nul/yfe/upg/zhy/nzo/dtp/nqt/hqk/./../ref/gms/zhp/./bpp/jis/ccc/bmn/iip/nfv/../vbk/ugr/gpd/uez/./bqt/zqy/../vuf/ltg/mxm/../lvr/vef/../wpp/./rbc/xii/pkf/jsx/././xwo");
//        simplifyPath("/../");
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(34);
arrayList.add(35);
arrayList.add(27);
arrayList.add(42);
arrayList.add(5);
arrayList.add(29);
arrayList.add(39);
arrayList.add(20);
arrayList.add(28);
prevSmaller(arrayList);


    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.search(0);
    }

    public int getMin() {
        Stack<Integer> tempStack = new Stack<>();
        int min  = stack.search(0);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            tempStack.push(temp);
            if(min > temp){
                min = temp;
            }
        }

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }

        return min;

    }


    public static  void simplifyPath(String A) {

       Stack<String> allPaths = new Stack<>();
       if (A.charAt(A.length() - 1) == '/') {
           A = A.substring(0, A.length() - 1);
       }
       String[] splittedA = A.split("/");

        for (int i=1; i<splittedA.length; i++) {

            if (splittedA[i].equals("..")) {
                if (!allPaths.isEmpty())
                    allPaths.pop();
            } else if (!splittedA[i].equals(".") && !splittedA[i].equals("")) {
                allPaths.push(splittedA[i]);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        System.out.println("/" + allPaths.stream().collect(Collectors.joining("/")));

        while (!allPaths.isEmpty()){
            sb.append(allPaths.pop() + "/");
        }
        System.out.println(sb.toString());

    }
    public ListNode deleteDuplicates(ListNode A) {

        while(A.next != null){
            ListNode B = A.next;
            if(B.val == A.val){
                A.next = B.next;
            }
        }

        return A;
    }


    public static int knight(int A, int B, int C, int D, int E, int F) {

        if (C == E && D == F) {
            return 0;
        }
        Queue<Node> possiblePoints = new LinkedList<>();
        Queue<List<Node>> previousPoints = new LinkedList<>();
        Map<String, Node> visitedList = new HashMap<>();
        Queue<Integer> jumpPoint = new ArrayDeque<>();
        possiblePoints.add(new Node(C, D));
        ((LinkedList<List<Node>>) previousPoints).push(new ArrayList<>());
        jumpPoint.add(0);
        while (possiblePoints.size() > 0) {

            int[] row = {1, 1, -1, -1, 2, 2, -2, -2};
            int[] col = {2, -2, 2, -2, 1, -1, -1, 1};

            Node n = ((LinkedList<Node>) possiblePoints).pop();
            List<Node> parents = ((LinkedList<List<Node>>) previousPoints).pop();
            List<Node> prevParents = new ArrayList<>(parents);
            prevParents.add(n);
            Integer jump = ((ArrayDeque<Integer>) jumpPoint).pop();

            for (int i = 0; i < row.length; i++) {
                if (n.x + row[i] <= A && n.y + col[i] <= B && n.x + row[i] > 0 && n.y + col[i] > 0) {
                    if (n.x + row[i] == E && n.y + col[i] == F) {
                        return jump + 1;
                    }
                    Node newNode = new Node(n.x + row[i], n.y + col[i]);
                    if (visitedList.get((n.x + row[i]) + "-" + (n.y + col[i])) == null) {
                        possiblePoints.add(newNode);
                        ((LinkedList<List<Node>>) previousPoints).push(prevParents);
                        visitedList.put((n.x + row[i]) + "-" + (n.y + col[i]), newNode);
                        ((ArrayDeque<Integer>) jumpPoint).push(jump + 1);
                    }
                }
            }
        }

        return -1;
    }
}


class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "" + x + "," + y;
    }
}

//class ListNode {
//      public int val;
//      public ListNode next;
//      ListNode(int x) { val = x; next = null; }
// }
