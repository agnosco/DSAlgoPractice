package practice;

public class ExcelColNo {
    public static void main(String[] args) {

        System.out.println(new ExcelColNo().getTitle(25));
        System.out.println(new ExcelColNo().getTitle(26));
        System.out.println(new ExcelColNo().getTitle(27));
        System.out.println(new ExcelColNo().getTitle(701));
        String s = "ZY";
        char[] charArr = s.toCharArray();

        int j = 1;
        int col = 0;
        int k = charArr.length -1;
        for(int i= 0; i < charArr.length; i++){
            col = col + (int) Math.pow(26,k)  * (s.charAt(i) - 64) ;
            k--;
//            System.out.println(Integer.valueOf((charArr[i] - 64)));
        }
//        System.out.println(col);
    }

    public String getTitle(int num){
        StringBuilder title = new StringBuilder();
        while(num != 0){
            title.append((char) ((num-1) % 26 + 65) );
            num = num / 26;
        }
        return title.reverse().toString();

    }
}
