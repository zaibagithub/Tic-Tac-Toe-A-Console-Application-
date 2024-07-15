import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        char[][] arr = new char[3][3];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        int moveCount = 0; 
        Scanner s = new Scanner(System.in);

        while (!gameOver) {
            printBoard(arr);
            System.out.print("Player " + player + " enter: ");
            int row = s.nextInt();
            int col = s.nextInt();
            System.out.println();

            if (arr[row][col] == ' ') {
                arr[row][col] = player;
                moveCount++;
                gameOver = hasWon(arr, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won the game ");
                } else if (moveCount == 9){
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } 
                else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } 
            else {
                System.out.println("Invalid move, try again");
            }
        }
        printBoard(arr);
    }

    public static boolean hasWon(char[][] arr, char player) {
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][0] == player && arr[row][1] == player && arr[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < arr[0].length; col++) {
            if (arr[0][col] == player && arr[1][col] == player && arr[2][col] == player) {
                return true;
            }
        }
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
            return true;
        } 
        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
