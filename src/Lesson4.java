import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    /**
     * прочитать чем чреват такой подход из методички
     */
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] field;
    public static int[][][][] priorityField; //компьютер будет определять по значениям в массиве куда наилучше поставить свой символ. 3я координата отвечает за приоритет по горизонтали, по вертикали, по диагонали, и сумму этих приоритетов
    public static final int sizeField = 3;
    public static final int dotsToWin = 3;
    public static String availableCoordinates = "[1";
    public static final char emptySign = '•';
    public static final char playerSign = 'X';
    public static final char computerSign = 'O';
    public static final String playerName = "Player";
    public static String currentPlayerName;
    public static char currentPlayerSign;


    public static void main(String[] args) {
        playTicTacToe();
    }

    static void playTicTacToe() {
        getFields();
        drawField();
        currentPlayerSign = playerSign;
        currentPlayerName = playerName;

        while (true) {
            move();

            if (checkWin()) {
                drawField();
                System.out.println(String.format("Congrats!!! You are winner Mr. %s", currentPlayerName));
                break;
            }

            if (checkFieldToFull()) {
                drawField();
                System.out.println("Standoff!!!");
                break;
            }

            currentPlayerSign = currentPlayerSign == playerSign ? computerSign : playerSign;
            currentPlayerName = currentPlayerSign == playerSign ? playerName : "Computer";
            drawField();
        }

    }

    static void move() {
        if (currentPlayerSign == playerSign) {
            movePlayerSign();
        } else {
            moveComputer();
        }
    }

    static void moveComputer() {
        int x;
        int y;
        Random random = new Random();

        int[][] maxPriorityValue = findMaxPriority();
        int v = random.nextInt(maxPriorityValue.length);
        x = maxPriorityValue[v][0];
        y = maxPriorityValue[v][1];
//        do {
//            x = random.nextInt(sizeField);
//            y = random.nextInt(sizeField);
//        } while (field[x][y] != emptySign);

        System.out.println("Computer's move ...");
        System.out.println(String.format("Computer decided choose coordinates [%s, %s]", y + 1, x + 1));
        field[x][y] = computerSign;
        fillPriorityField(x, y, 0);
    }

    static int[][] findMaxPriority() {

        int[][] maxPriorityComputerValueList = findMaxArrayValue(0);
        int[][] maxPriorityPlayerValueList = findMaxArrayValue(1);
        if(maxPriorityPlayerValueList[maxPriorityPlayerValueList.length-1][2] >= maxPriorityComputerValueList[maxPriorityComputerValueList.length-1][2]){
            return maxPriorityPlayerValueList;
        }
        return  maxPriorityComputerValueList;
    }

    static int[][] findMaxArrayValue(int n) {
        int maxValue = 0;
        int sumValuesInCell = 0;
        int[][] coordinatesList = new int[0][3];
        for (int k = 0; k < 3; k++) {
            for(int i = 0; i<sizeField; i++) {
                for (int j = 0; j < sizeField; j++) {
                    if (priorityField[i][j][k][n] > maxValue || (priorityField[i][j][k][n] == maxValue && sumValuesInCell < priorityField[i][j][3][n])) {
                        maxValue = priorityField[i][j][k][n];
                        coordinatesList = new int[0][3];
                        sumValuesInCell = priorityField[i][j][3][n];
                    }
                    if (priorityField[i][j][k][n] == maxValue && sumValuesInCell==priorityField[i][j][3][n]) {
                        coordinatesList = createNewArr(coordinatesList);
                        coordinatesList[coordinatesList.length - 1][0] = i;
                        coordinatesList[coordinatesList.length - 1][1] = j;
                        coordinatesList[coordinatesList.length - 1][2] = maxValue;
                    }
                }
            }
        }
        return coordinatesList;
    }

    static int[][] createNewArr(int[][] coordinatesList) {
        int[][] newArray = new int[coordinatesList.length+1][3];
        for (int i = 0; i < coordinatesList.length; i++) {
            for (int j = 0; j < 3; j++) {
                newArray[i][j] = coordinatesList[i][j];
            }
        }
        return newArray;
    }


    static void movePlayerSign() {
        int x;
        int y;
        boolean isCorrectCoordinates;
        do {
            System.out.println("Input X-coordinates " + availableCoordinates);
            y = scanner.nextInt() - 1;
            System.out.println("Input Y-coordinates " + availableCoordinates);
            x = scanner.nextInt() - 1;
            isCorrectCoordinates = checkCoordinates(x, y);
        } while (!isCorrectCoordinates);
        field[x][y] = playerSign;
        fillPriorityField(x, y, 1);
    }

    static boolean checkWin() {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
//                if (j<=(sizeField-DOTS_TO_WIN)){
                if (j <= (sizeField - dotsToWin) && checkHorizontalWin(i, j)) return true;
                if (j <= (sizeField - dotsToWin) && i <= (sizeField - dotsToWin) && checkDiagonalWin(i, j, 1))
                    return true;
                if (j >= (dotsToWin - 1) && i <= (sizeField - dotsToWin) && checkDiagonalWin(i, j, -1)) return true;
                if (i <= (sizeField - dotsToWin) && checkVerticalWin(i, j)) return true;
//                }
            }
        }
        return false;
    }

    static boolean checkFieldToFull() {
        for (char[] i : field) {
            for (char j : i) {
                if (j == emptySign) return false;
            }
        }
        return true;
    }

    static boolean checkHorizontalWin(int x, int y) {
        for (int i = 0; i < dotsToWin; i++) {
            if (field[x][y + i] != currentPlayerSign)
                return false;
        }
        return true;
    }

    static boolean checkVerticalWin(int x, int y) {
        for (int i = 0; i < dotsToWin; i++) {
            if (field[x + i][y] != currentPlayerSign)
                return false;
        }
        return true;
    }

    static boolean checkDiagonalWin(int x, int y, int n) {
        for (int i = 0; i < dotsToWin; i++) {
            if (field[x + i][y + (i * n)] != currentPlayerSign)
                return false;
        }
        return true;
    }

    static void notifyOccupiedCell(int x, int y) {
        System.out.println(String.format("Input coordinates are incorrect. Cell of coordinates [%s, %s] is already occupied", y + 1, x + 1));
        drawField();
    }

    static void notifyIncorrectCoordinates() {
        System.out.println("Input coordinates are incorrect. Available coordinates in range " + availableCoordinates);
        drawField();
    }

    static boolean checkCoordinates(int x, int y) {
        if (!((x >= 0 && x < sizeField) && (y >= 0 && y < sizeField))) {
            notifyIncorrectCoordinates();
            return false;
        }
        if (field[x][y] != emptySign) {
            notifyOccupiedCell(x, y);
            return false;
        }
        return true;
    }

    static void fillPriorityField(int x, int y, int playerNumber) {
        for (int n = 0; n < 4; n++) {
            priorityField[x][y][n][0] = 0;
            priorityField[x][y][n][1] = 0;
        }
        //переменные определяют край диагонали на поле от поставленного знака:
        int diagonalXminExtreme = x < y ? 0 : (x - y);
        int diagonalXmaxExtreme = (x + y) < sizeField ? (x + y) : (sizeField - 1);
        int diagonalYminExtreme = x < y ? (y - x) : 0;
        int diagonalYmaxExtreme = (x + y) >= sizeField ? (x + y - sizeField + 1) : 0;

        for (int i = 0; i < sizeField; i++) {
            if (field[x][i] == emptySign) fillHorizonPriority(x, i, playerNumber);
            if (field[i][y] == emptySign) fillVerticalPriority(i, y, playerNumber);
            if ((diagonalXminExtreme + i) < sizeField && (diagonalYminExtreme + i) < sizeField && field[diagonalXminExtreme + i][diagonalYminExtreme + i] == emptySign)
                fillDiagonalPriority(diagonalXminExtreme, diagonalYminExtreme, i, 1, playerNumber);
//                priorityField[diagonalXminExtreme + i][diagonalYminExtreme + i][2][playerNumber]++;
            if ((diagonalXmaxExtreme - i) >= 0 && (diagonalYmaxExtreme + i) < sizeField && field[diagonalXmaxExtreme - i][diagonalYmaxExtreme + i] == emptySign)
                fillDiagonalPriority(diagonalXmaxExtreme, diagonalYmaxExtreme, i, -1, playerNumber);
//                priorityField[diagonalXmaxExtreme - i][diagonalYmaxExtreme + i][2][playerNumber]++;
        }
    }

    static void drawField() {
        System.out.print("  y" + "\nx ");
        for (int i = 0; i <= sizeField; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            System.out.print("  " + (i + 1) + " ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void getFields() {
        field = new char[sizeField][sizeField];
        priorityField = new int[sizeField][sizeField][4][2];
        for (int i = 2; i <= sizeField; i++) {
            availableCoordinates = availableCoordinates + ", " + i;
        }
        availableCoordinates = availableCoordinates + "]";

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = emptySign;
                for (int n = 0; n < 3; n++) {
                    priorityField[i][j][n][0] = 0;
                    priorityField[i][j][n][1] = 0;
                }
            }
        }
    }

    static void fillHorizonPriority(int x, int i, int playerNumber){
        priorityField[x][i][0][playerNumber]++;
        priorityField[x][i][3][playerNumber]++;
    }

    static void fillVerticalPriority(int i, int y, int playerNumber){
        priorityField[i][y][1][playerNumber]++;
        priorityField[i][y][3][playerNumber]++;
    }

    static void fillDiagonalPriority(int x, int y, int i, int v, int playerNumber){
        priorityField[x + (i*v)][y + i][2][playerNumber]++;
        priorityField[x + (i*v)][y + i][3][playerNumber]++;
    }
}
