package practice;

public class ValidTicTactoe {
        public static void  main(String[] args){

            String[] board = new String[]{"XXX","OOX","OOX"};
             isValid(board, 0, 0, 0, 0);
        }

        public static  boolean isValid(String[] board, int countX, int countO, int row, int charPos){

            if(row > 3){
                return false;
            }

            if(board[row].charAt(charPos) == 'O'){
                countO++;
            }else if(board[row].charAt(charPos) == 'X'){
                countX++;
            }

            charPos++;
            if(charPos == 3){
                row++;
                charPos = 0;
            }

            if(row == 3){

                if((countO > countX || countX > countO + 1) || isCharWin("OOO", board) && isCharWin("XXX", board)){
                    return false;
                }

                return true;
            }

            return isValid(board, countX, countO, row, charPos);


        }

        public static boolean isCharWin(String s, String[] board){


            if(wonByRow(s, board) || wonByCol(s, board)){
                return true;
            }


            return false;

        }

        public static boolean wonByRow(String s, String[] board){
            for(int i = 0; i < 3; i++){
                if(s.equals(board[i])){
                    return true;
                }
            }
            return false;
        }
        public static boolean wonByCol(String s, String[] board){
            for(int i = 0; i < 3; i++){
                if((board[0].charAt(i) ==  s.charAt(0)
                        && board[1].charAt(i) ==  s.charAt(0)
                        && board[2].charAt(i) ==  s.charAt(0))
                ){
                    return true;
                }
            }
            return false;
        }

    }

