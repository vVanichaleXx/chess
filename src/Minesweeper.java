import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int FIELD_LENGTH = 8;
    private static char[][] mines = new char[FIELD_LENGTH][FIELD_LENGTH];
    private static char[][] field = new char[FIELD_LENGTH][FIELD_LENGTH];

    public static void main(String[] args) {
        drawField();
        putMines(20);

        System.out.println("WHAT THE PLAYER SEES:");
        System.out.println(printMinesField(field));

        System.out.println("WHERE THE MINES ARE:");
        System.out.println(printMinesField(mines));

        usernumber();
    }


    private static void usernumber()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do u wanna play? Press Y or N.");
        String accesstoplay = scan.nextLine();

        System.out.println("Enter row number");
        int rowNumber = scan.nextInt();

        System.out.println("Enter column number");
        int colNumber = scan.nextInt();

        if (mines[rowNumber][colNumber] == '*') {
            System.out.println("YOU ARE A LOOSER YOU HITTED A BOMB");
        } else {
            System.out.println("NICE");
        }
    }



    private static String printMinesField(char[][] fieldToPrint) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char[] row: fieldToPrint) {
            for (char value: row) {
                stringBuilder.append(value);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static void putMines(int numberOfBombsToPlace) {
        Random random = new Random();
        int bombCounter = 0;

        while (bombCounter < numberOfBombsToPlace) {
            int rowForBomb = random.nextInt(FIELD_LENGTH);
            int columnForBomb = random.nextInt(FIELD_LENGTH);

            //If already a bomb find new random position
            if (mines[rowForBomb][columnForBomb] != '*') {
                mines[rowForBomb][columnForBomb] = '*';
                bombCounter +=1;
            }
        }

//        int cb;
//        int rb;
//
//        int cb = int[colbomb];
//        int rb = int[rowbomb];
//
//        if(minesField == 0)
//        {
//            Random rand = new Random();
//            int cb = rand.nextInt(8);
//            return true;
//                else
//            {
//                return false;
//            }
//        }
    }

    private static void drawField() {
        for (char[] row : field) {
            Arrays.fill(row, '#');
        }
    }
}
