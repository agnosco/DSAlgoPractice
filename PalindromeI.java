package practice;

public class PalindromeI {
    public static void main(String[] args) {
        System.out.println(validPalindrome("ababca"));
        System.out.println(validPalindrome("cappacu"));
        validPalindrome("cappacu");
    }
        public  static boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length() -1;
            int count = 0;

            while(start <= end){
                if(s.charAt(start) == s.charAt(end)){
                    start++;
                    end--;
                }else{
                    if(count == 1){
                        return false;
                    }
                    if(s.charAt(start + 1) == s.charAt(end)){
                        start++;
                    }else if(s.charAt(start) == s.charAt(end -1)){
                        end--;
                    }else{
                        return false;
                    }
                    count++;
                }

            }

            return true;



        }

}
