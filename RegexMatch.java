package practice;

public class RegexMatch {
    public static void main(String[] args) {
        System.out.println(new RegexMatch().isMatch( "ab", ".b*"));
    }

    public boolean isMatch(String s, String p) {
       if(p.isEmpty()){
           return  s.isEmpty();
       }
       boolean firstMatch = !s.isEmpty() && p.charAt(0) == s.charAt(0) || p.charAt(0) == '.';
       if(p.length() >= 2 && p.charAt(1) == '*'){
           s.indexOf("a");
           return isMatch(s, p);
       }else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }


}
