public class TicTacToe2 {
    public static void main (String[] args) {
        String[][] board = new String[6][9];

        board[0][0] = " ";
        board[0][1] = " ";
        board[0][2] = " ";
        board[0][3] = "A";
        board[0][4] = " ";
        board[0][5] = "B";
        board[0][6] = " ";
        board[0][7] = "C";
        board[0][8] = " ";
        board[1][0] = " ";
        board[1][1] = "1";
        board[1][2] = "|";
        board[1][3] = " ";
        board[1][4] = "|";
        board[1][5] = " ";
        board[1][6] = "|";
        board[1][7] = " ";
        board[1][8] = " ";
        board[2][0] = " ";
        board[2][1] = "-";
        board[2][2] = "-";
        board[2][3] = "-";
        board[2][4] = "-";
        board[2][5] = "-";
        board[2][6] = "-";
        board[2][7] = "-";

        int row = 0;
        for (int col = 0; col < board.length; col++) {
            for (row = 0; row < board[col].length; row++) {
                System.out.print(board[col][row]);
                if (row == 7) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}