import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int FIELD_LENGTH = 8;
    private static final char[][] mines = new char[FIELD_LENGTH][FIELD_LENGTH];
    private static final char[][] field = new char[FIELD_LENGTH][FIELD_LENGTH];
    static int rowNumber;
    static int colNumber;
    static int rowForBomb;
    static  int columnForBomb;
    public static void main(String[] args) {

        putMines(5);

        System.out.println("WHAT THE PLAYER SEES:");
        System.out.println(printMinesField(field));

        System.out.println("WHERE THE MINES ARE:");
        System.out.println(printMinesField(mines));

        Scanner scan = new Scanner(System.in);
        System.out.println("Do u wanna play? Press Y or N.");
        String accesstoplay = scan.nextLine();
        if (accesstoplay.equalsIgnoreCase("N")) {
            System.out.println("U are anyway loser");
        } else {
            System.out.println("Type your Username here: ");
            accesstoplay = scan.nextLine();
        }

        int oneTurn = 1;
        char player = '°';
        boolean hasLost = false;

      while(!hasLost && (oneTurn <= 40)) {
        System.out.println("Player " + accesstoplay + ", choose a column: ");
        colNumber = scan.nextInt();
        colNumber -= 1;

        System.out.println("Enter row number");
        rowNumber = scan.nextInt();
        rowNumber -= 1;

          if (rowNumber >= 8 || colNumber >= 8) {
              System.out.println("Please enter another number, maximal number value 8.");
          } else {
              hasLost = userNumber();
              field[rowNumber][colNumber] = player;

              System.out.println("WHAT THE PLAYER SEES:");
              System.out.println(printMinesField(field));
              System.out.println(printMinesField(mines));
          }
      }
    }

    private static boolean userNumber()
    {
        if (mines[rowNumber][colNumber] == '*') {
            System.out.println("YOU ARE A LOOSER YOU HITTED A BOMB");
            return true;
        }

        if (isInRange(rowNumber - 1) && isInRange(colNumber - 1)) {
            char a = mines[rowNumber - 1][colNumber - 1];
            if(a != '*')
            {
                mines[rowNumber - 1][colNumber - 1] += 1;
                System.out.print(a);
            }
        }

        if (isInRange(rowNumber -1 ) && isInRange(colNumber)) {
            char b = mines[rowNumber - 1][colNumber];
            if(b != '*')
            {
                mines[rowNumber - 1][colNumber] += 1;
                System.out.print(b);
            }
        }
        if (isInRange(rowNumber - 1 ) && isInRange(colNumber + 1)) {
            char c = mines[rowNumber - 1][colNumber + 1];
            if(c != '*')
            {
                mines[rowNumber - 1][colNumber + 1] += 1;
                System.out.print(c);
            }
        }
        if (isInRange(rowNumber) && isInRange(colNumber - 1)) {
            char d = mines[rowNumber][colNumber - 1];
            if(d != '*')
            {
                mines[rowNumber][colNumber - 1] += 1;
                System.out.print(d);
            }
        }
        if (isInRange(rowNumber) && isInRange(colNumber + 1)) {
            char e = mines[rowNumber][colNumber + 1];
            if(e != '*')
            {
                mines[rowNumber][colNumber + 1] += 1;
                System.out.print(e);
            }
        }
        if (isInRange(rowNumber + 1 ) && isInRange(colNumber - 1)) {
            char f = mines[rowNumber + 1][colNumber - 1];
            if(f != '*')
            {
                mines[rowNumber + 1][colNumber - 1] += 1;
                System.out.print(f);
            }
        }
        if (isInRange(rowNumber + 1 ) && isInRange(colNumber)) {
            char g = mines[rowNumber + 1][colNumber];
            if(g != '*')
            {
                mines[rowNumber + 1][colNumber] += 1;
                System.out.print(g);
            }
        }
        if (isInRange(rowNumber + 1 ) && isInRange(colNumber + 1)) {
            char h = mines[rowNumber + 1][colNumber + 1];
            char playerField = '°';
            if(h != '*')
            {
                mines[rowNumber + 1][colNumber + 1] += 1;
                System.out.print(h);
                if (playerField == h) {
                    field[rowNumber][colNumber] = 1;
                    System.out.println();
                }
            }
        }
        return false;
    }
    private static String printMinesField(char[][] fieldToPrint)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : fieldToPrint) {
            for (char value : row) {
                stringBuilder.append(value);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    private static void putMines(int numberOfBombsToPlace)
    {
        Random random = new Random();
        int bombCounter = 0;
        for (int i = 0; i < mines.length; i++) {
            Arrays.fill(mines[i], (char) 48);
        }
        while (bombCounter < numberOfBombsToPlace) {
            rowForBomb = random.nextInt(FIELD_LENGTH);
            columnForBomb = random.nextInt(FIELD_LENGTH);

            //If already a bomb find new random position
            if (mines[rowForBomb][columnForBomb] != '*') {
                mines[rowForBomb][columnForBomb] = '*';
                bombCounter += 1;

            }
        }
    }

    /**
     * Checks if the number ist greater than 0 and lower than 8
     * @param number
     * @return return true if the number ist between 0 and 8. Otherwise, return false;
     */
    private static boolean isInRange(int number){
        return number > 0 && number < 8;
    }
    private static void drawField() {
        for (char[] row : field) {
            Arrays.fill(row, '#');
        }
    }
}
