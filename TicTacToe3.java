import java.util.Scanner;

public class TicTacToe3 {
    public static void turnAction (int player) {
        char piece = (player == 1 ? 'X' : 'O');
        System.out.println("Player " + player + ", please choose a coordinate to place your " + piece + " on the board");
    }
    
    // public static char[][] printBoard (int col, int row, char[][] board) {
        
    // }

    public static void main (String[] args) {
        Scanner keyboard = new Scanner (System.in);

        char [][] board = new char [6][9];
        int row = 0;
        int letter = 65;
        char counter = '1';

        int player = 1;
        boolean badInput = true;
        String[] goodLetterInputs = {"A", "B", "C"};
        String[] goodNumberInputs = {"1", "2", "3"};

        // Builds board inside of board 2D array
        for (int col = 0; col < board.length; col++) {
            for (row = 0; row < board[col].length; row++) {
                // only odd column (1, 3, 5) that have row values 4 or 6
                if (col % 2 == 1 && col > 0 && (row == 4 || row == 6)) {
                    board[col][row] = '|';
                // only even column (2, 4) (except 0) that go from row 3 to 7
                } else if (col % 2 == 0 && col > 0 && row > 2 && row < 8) {
                    board[col][row] = '-';
                // place letters on the 0 column in odd rows except 1
                } else if (col == 0 && row % 2 == 1 && row > 1) {
                    board[col][row] = (char)letter;
                    letter ++;
                // put numbers on the odd columns (1, 3, 5) in the first row
                } else if (col % 2 == 1 && col > 0 && row == 1) {
                    board[col][row] = counter;
                    counter ++;
                } else {
                    board[col][row] = ' ';
                }
                // System.out.print(board[col][row]);
                // if (row == 7) {
                //     System.out.println();
                //     break;
                // }
            }
        }
        // Welcome message and instructions
        System.out.println("Welcome to Tic Tac Toe! How this game will work as follows");
        System.out.println("1. Player 1 and Player 2 will take turns placing X and O on the board with Player 1 starting first with piece X");
        System.out.println("2. To indicate the location, refer to the boxes by their coordinate values with a space in between");
        System.out.println("For example the top left corner is A 1");
        System.out.println("3. A win occurs when rows are completed vertically, horizontally or diagonally");
        System.out.println("Good Luck! :)");
        System.out.println();

        badLoop:
        while (badInput) {
            turnAction(player);
            String coordinate = keyboard.nextLine();
            String letterCoordinate = (coordinate.indexOf(" ") != -1 ? coordinate.substring(0, coordinate.indexOf(" ")) : "");
            String numberCoordinate = (coordinate.indexOf(" ") != -1 ? coordinate.substring(coordinate.indexOf(" ") + 1) : "");
            
            // Checks if the coordinates entered are valid
            for (int i = 0; i < goodLetterInputs.length; i++) {
                if (goodLetterInputs[i].equals(letterCoordinate.toUpperCase())) {
                    break;
                } else if (i == 2) {
                    System.out.println("Invalid letter coordinate, please try again");
                    continue badLoop;
                }
            }
            for (int i = 0; i < goodNumberInputs.length; i++) {
                if (goodNumberInputs[i].equals(numberCoordinate)) {
                    badInput = false;
                    break;
                } else if (i == 2) {
                    System.out.println("Invalid number coordinate, please try again");
                    continue badLoop;
                }
            }
        
        player = player == 1 ? 2 : 1;
        }
    }
}