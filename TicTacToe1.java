public class TicTacToe1 {
    public static void main (String[] args) {
        String[][] board = new String[5][8];
        int row = 0;
        for (int col = 0; col < board.length; col++) {
            for (row = 0; row < board[col].length; row++) {

                if (col == 1|| col == 3) {
                    board[col][row] = "-";
                } else if (row == 2 || row == 5) {
                    board[col][row] = "|";
                } else {
                    board[col][row] = " ";
                }
                System.out.print(board[col][row]);
                if (row == 7) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}