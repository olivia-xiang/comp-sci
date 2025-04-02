import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToe {
    public static void turnAction(int player, char piece) {
        System.out.println();
        System.out
                .println("Player " + player + ", please choose a coordinate to place your " + piece + " on the board");
    }

    public static int adjustCoord(int coord) {
        switch (coord) {
            case 49:
            case 65:
                return 1;
            case 50:
            case 66:
                return 3;
            default:
                return 5;
        }
    }

    public static boolean updateBoard(char[][] board, int letterCoord, int numCoord, int player, char piece) {
        if (board[numCoord][letterCoord] == ' ') {
            board[numCoord][letterCoord] = piece;
            return false;
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (char col[] : board) {
            System.out.println(col);
        }
    }

    public static boolean findWinner(char[][] board, int player, int letterCoord, int numCoord, int piecesPlaced,
            char piece) {
        String method = "";

        if (board[numCoord][1] == piece && board[numCoord][3] == piece &&
                board[numCoord][5] == piece) {
            method += "horizontally";
        } else if (board[1][letterCoord] == piece && board[3][letterCoord] == piece
                && board[5][letterCoord] == piece) {
            method += "vertically";
        } else if ((board[1][1] == piece && board[5][5] == piece
                || board[5][1] == piece && board[1][5] == piece) && board[3][3] == piece) {
            method += "diagonally";
        } else if (piecesPlaced == 9) {
            System.out.println("Player 1 and Player 2 tie");
            return true;
        }
        System.out.println(method == "" ? "" : "Player " + player + " wins " + method);
        return (method == "" ? false : true);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        char[][] board = new char[6][6];
        int colAsciiLetter = 65;
        char rowNumber = '1';
        int player = 1;
        char piece = 'X';
        int piecesPlaced = 0;
        char letterCoord = ' ';
        char numCoord = ' ';

        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if (col == 0 && row % 2 == 1) {
                    board[col][row] = (char) colAsciiLetter;
                    colAsciiLetter++;
                } else if (row == 0 && col % 2 == 1) {
                    board[col][row] = rowNumber;
                    rowNumber++;
                } else if (row % 2 == 0 && row != 0 && col % 2 == 1) {
                    board[col][row] = '|';
                } else if (row > 0 && col % 2 == 0 && col != 0) {
                    board[col][row] = '-';
                } else {
                    board[col][row] = ' ';
                }
            }
        }

        System.out.println("Welcome to Tic Tac Toe! The game will work as follows");
        System.out.println(
                "1. Player 1 and Player 2 will take turns placing X and O on the empty boxes on the board with Player 1 starting first with piece X");
        System.out.println("2. To indicate the location, refer to the boxes with their coordinate values");
        System.out.println(
                "For example the top left corner is A1, ensure that there is no space inbetween when entering it");
        System.out.println(
                "3. A win occurs when boxes are completed vertically, horizontally or diagonally by one piece");
        System.out.println("Good Luck! :)");
        System.out.println();
        printBoard(board);

        askInput: while (true) {
            turnAction(player, piece);
            String userInput = keyboard.nextLine();

            if (userInput.length() == 2) {
                letterCoord = userInput.toUpperCase().charAt(0);
                numCoord = userInput.charAt(1);

                if ((Pattern.compile("[ABC]").matcher(Character.toString(letterCoord))).find()) {
                    if ((Pattern.compile("[123]").matcher(Character.toString(numCoord))).find()) {
                        if (updateBoard(board, adjustCoord(letterCoord), adjustCoord(numCoord), player, piece)) {
                            System.out.println("Coordinate " + letterCoord + numCoord
                                    + " is already taken, please enter another coordinate");
                            continue askInput;
                        }
                        piecesPlaced++;
                        printBoard(board);
                        if (findWinner(board, player, adjustCoord(letterCoord), adjustCoord(numCoord),
                                piecesPlaced, piece)) {
                            keyboard.close();
                            System.exit(1);
                        }
                        player = player == 1 ? 2 : 1;
                        piece = piece == 'X' ? 'O' : 'X';
                        continue askInput;
                    }
                }
                System.out.println("Invalid coordinate: Letter or number coordinate not present on the board");
            } else {
                System.out.println("Invalid coordinate: Coordinate needs to be two characters long");
            }
        }
    }
}