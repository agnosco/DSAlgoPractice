package practice;

import org.apache.commons.io.FilenameUtils;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
//        System.out.println(new SimplifyPath().simplify("/a/.//b/../../c/ /"));
        System.out.println(new SimplifyPath().simplify("/../"));
    }

    private String simplify(String s) {
//        return FilenameUtils.getPath("/a/./b/../../c/ /");
        Stack<String> stack = new Stack<>();
        String finalString = "";
        for(String sub : s.split("/")){
            System.out.println(sub);
            if(!stack.isEmpty() && sub.equals("..")){
                stack.pop();
            }else if(!sub.trim().equals("") && !sub.equals(".") &&  !sub.equals("..")){
                stack.push(sub);
            }
        }
        while(!stack.isEmpty()){
            finalString = "/" +  stack.pop() +  finalString;
        }
         return  stack.isEmpty() ? "/" : finalString;
    }
}
