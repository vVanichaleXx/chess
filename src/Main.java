import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String Himname;

    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Wassup");

        Scanner yesorno = new Scanner(System.in);
        System.out.println("Do u wanna play? Press Y or N.");
        String douwanna = yesorno.nextLine();



        Connect4.start();

    }

    public static class Connect4 {

        public static void start() {
            Scanner in = new Scanner(System.in);
            Scanner on = new Scanner(System.in);


            char[][] grid = new char[8][8];

//                //initialize array
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    grid[row][col] = ' ';
                }
            }




            int turn = 1;
            char player = '✸';
            boolean winner = false;

            //play a turn
            while (!winner && turn <= 63) {
                boolean validPlayw;
                boolean validPlay;
                int column;
                int row;
                do {
                    display(grid);

                    System.out.print("Player " + Himname + ", choose a column: ");
                    column = on.nextInt();
                    row = in.nextInt();

                    //validate play
                    validPlay = validPosition(row, column, grid);
                    validPlayw = Maximalinput(row, column);

                    if (!validPlay && !validPlayw) {
                        System.out.println();
                    }
                }
                while (!validPlay && !validPlayw);
//                    while (!validPlayw);

                //drop the checker
             //   while(column !=)
                grid[column][row] = player;
//                    for (int col = grid.length - 1; col >= 0; col--) {
//
//                            grid[col][play] = player;
//                            break;
//                        }
//                    }

                //determine if there is a winner
                winner = isWinner(player, grid);

                //switch players
                if (player == '✸') {
                    player = '✸';
                } else {
                    player = '✸';
                }

                turn += 1;

//                    turn++;
//                    ++turn;
            }
            display(grid);
        }



        //was winner

        public static void display(char[][] grid) {
            System.out.println(" 0 1 2 3 4 5 6 7 ");
            System.out.println(" ☰ ☰ ☰ ☰ ☰ ☰ ☰ ");
            for (int row = 0; row < grid.length; row++) {
                System.out.print("║");
                for (int col = 0; col < grid[0].length; col++) {

                    System.out.print(grid[row][col]);
                    System.out.print("║");
                }
                System.out.println();
                System.out.println(" ☰ ☰ ☰ ☰ ☰ ☰ ☰ ");
            }
            System.out.println(" 0 1 2 3 4 5 6 7 ");
            System.out.println();
        }

        public static boolean validPosition(int row, int column, char[][] grid) {
            if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length) {
                return false;
            }

            if (grid[row][column] != ' ') {
                return false;
            }

            return true;
        }

        public static boolean Maximalinput(int row, int column) {
            if (row <= 8 || column <= 8) {
                return true;
            }
            System.out.println("Please enter another number, maximal number value 7.");
            return false;
        }

        public static boolean isWinner(char player, char[][] grid) {
            //check for 4 across
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 3; col++) {
                    if (grid[row][col] == player &&
                            grid[row][col + 1] == player &&
                            grid[row][col + 2] == player &&
                            grid[row][col + 3] == player) {
                        return true;
                    }
                }
            }
            //check for 4 up and down
            for (int row = 0; row < grid.length - 3; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == player &&
                            grid[row + 1][col] == player &&
                            grid[row + 2][col] == player &&
                            grid[row + 3][col] == player) {
                        return true;
                    }
                }
            }
            //check upward diagonal
            for (int row = 3; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 3; col++) {
                    if (grid[row][col] == player &&
                            grid[row - 1][col + 1] == player &&
                            grid[row - 2][col + 2] == player &&
                            grid[row - 3][col + 3] == player) {
                        return true;
                    }
                }
            }
            //check downward diagonal
            for (int row = 0; row < grid.length - 3; row++) {
                for (int col = 0; col < grid[0].length - 3; col++) {
                    if (grid[row][col] == player &&
                            grid[row + 1][col + 1] == player &&
                            grid[row + 2][col + 2] == player &&
                            grid[row + 3][col + 3] == player) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
