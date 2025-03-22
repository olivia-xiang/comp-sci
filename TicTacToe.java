import java.util.Scanner;

public class TicTacToe {
    public static void turnAction (int player) {
        char piece = (player == 1 ? 'X' : 'O');
        System.out.println();
        System.out.println("Player " + player + ", please choose a coordinate to place your " + piece + " on the board");
    }
    public static int adjustCoord (int coordinate) {
        switch (coordinate) {
            case 49:
            case 65:
                return 1;
            case 50:
            case 66:
                return 3;
            case 51:
            default:
                return 5;
        }
    }
    public static boolean updateBoard (char[][]board, int letterCoord, int numCoord, int player) {
        if (board[numCoord][letterCoord] == ' ') {
            board[numCoord][letterCoord] = (player == 1 ? 'X' : 'O');
            return false;
        } else {
            return true;
        }
    }
    public static void printBoard (char[][] board) {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                System.out.print(board[col][row]);
                    if (row == 5) {
                        System.out.println();
                        break;
                }
            }
        }
    }
    public static boolean findWinner (char[][]board, int player, int letterCoord, int numCoord, int piecesPlaced) {
        char piece = (player == 1 ? 'X' : 'O');
        boolean win = false;
        String method = "";

        if (board[numCoord][1] == piece && board[numCoord][3] == piece && board[numCoord][5] == piece) {
            win = true;
            method += "horizontally";
        } else if (board[1][letterCoord] == piece && board[3][letterCoord] == piece && board[5][letterCoord] == piece) {
            win = true;
            method += "vertically";
        } else if ((board[1][1] == piece && board[5][5] == piece || board[5][1] == piece && board[1][5] == piece) && board[3][3] == piece) {
            win = true;
            method += "diagonally";
        } else if (piecesPlaced == 9) {
            System.out.println("Player 1 and Player 2 tie!");
                return true;
        }
        if (win) {
            System.out.println("Player " + player + " wins " + method + ", congratulations");
            return true;
        } 
        return false;
    }

    public static void main (String[] args) {
        Scanner keyboard = new Scanner (System.in);

        char [][] board = new char [6][6];
        int colAsciiLetter = 65;
        char rowNumber = '1';

        int player = 1;
        boolean badInput = true;
        char letterCoordinate = 'n';
        char numberCoordinate = 'n';
        String goodLetterInputs = "ABC";
        String goodNumberInputs = "123";

        int piecesPlaced = 0;

        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if (col == 0 && row % 2 == 1) {
                    board[col][row] = (char)colAsciiLetter;
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
        
        // Welcome message and instructions
        System.out.println("Welcome to Tic Tac Toe! The game will work as follows");
        System.out.println("1. Player 1 and Player 2 will take turns placing X and O on the board with Player 1 starting first with piece X");
        System.out.println("2. To indicate the location, refer to the boxes by their coordinate values");
        System.out.println("For example the top left corner is A1, ensure that there is no space inbetween");
        System.out.println("3. A win occurs when rows are completed vertically, horizontally or diagonally");
        System.out.println("Good Luck! :)");
        System.out.println();
        printBoard(board);

        askInput:
        while (badInput) { 
            turnAction(player);
            String userInput = keyboard.nextLine();
            letterCoordinate = userInput.toUpperCase().charAt(0);
            numberCoordinate = userInput.charAt(1);

            inputCheck:
            for (int i = 0; i < goodLetterInputs.length(); i++) {
                if (goodLetterInputs.charAt(i) == letterCoordinate) {
                    for (int j = 0; j < goodNumberInputs.length(); j++) {
                        if (goodNumberInputs.charAt(j) == numberCoordinate) {
                            break inputCheck;
                        }
                    }
                    System.out.println("Please enter a number located on the grid");
                    continue askInput;
                } else if (i == 2) {
                    System.out.println("Please enter a letter located on the grid");
                    continue askInput;
                } continue;
            }

            if (updateBoard(board, adjustCoord(letterCoordinate), adjustCoord(numberCoordinate), player)) {
                System.out.println("That space is already taken, please enter another");
                continue askInput;
            }
            piecesPlaced++;
            printBoard(board);
            if (findWinner(board, player, adjustCoord(letterCoordinate), adjustCoord(numberCoordinate), piecesPlaced)){
                keyboard.close();
                System.exit(1);
            }
           player = player == 1 ? 2 : 1; 
           continue askInput;
        }
    }
} 