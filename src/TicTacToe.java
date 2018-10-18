import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] a = new String[3][3];
        boolean f = false;

        start(a);

        while (!f) {
            while (move != 1 && !f) {
                HumanMoveFieldValue(a);
                nextMovePrintField(a);
                f = result(a);
            }

            while (move != 2 && !f) {
                CompMoveFieldValue(a);
                nextMovePrintField(a);
                f = result(a);
            }
        }
    }

    private static Integer move = 5;

     static void start(String[][] a) {

        System.out.println(("      ") + (char) 27 + "[31mWarning! \n The GAME has begun!" + (char) 27 + "[0m");
        firstPrintFieldValue(a);
        nextMovePrintField(a);
        System.out.println(("  ") + (char) 27 + "[31mTicTacToe v1.01" + (char) 27 + "[0m");
        System.out.println();

    }

    static void HumanMoveFieldValue(String[][] fields) {
        Scanner sc = new Scanner(System.in);
        int cell;
        int a = 0;

        cell = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a = a + 1;
                if (a == cell) {
                    if (fields[i][j].equals("\u25AA")) {
                        fields[i][j] = "\u2B55";
                        move = 1;
                        break;
                    }
                }
            }
        }
        if (move != 1) {
            System.out.println("Клетка занята");
        }
    }

    static void CompMoveFieldValue(String[][] fields) {
        Scanner sc = new Scanner(System.in);
        int cell;
        int a = 0;
        cell = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a = a + 1;
                if (a == cell) {
                    if (fields[i][j].equals("\u25AA")) {
                        fields[i][j] = "\u2715";
                        move = 2;
                        break;
                    }
                }
            }
        }
        if (move != 2) {
            System.out.println("Клетка занята");
        }
    }

    static void firstPrintFieldValue(String[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = "\u25AA";
            }
        }
    }

    static void printFieldUp() {
        System.out.print("   \u230C");
        for (int q = 0; q < 6; q++) {
            System.out.print("\u2015");
        }
        System.out.print("\u230D");
        System.out.println();
    }

    static void printFieldDown() {
        System.out.print("   \u230E");
        for (int q = 0; q < 6; q++) {
            System.out.print("\u2015");
        }
        System.out.print("\u230F");
        System.out.println();
    }

    static void nextMovePrintField(String[][] nextFields) {

        printFieldUp();
        for (int i = 0; i < nextFields.length; i++) {
            System.out.print("   \u23A2 ");
            for (int j = 0; j < nextFields[i].length; j++) {
                System.out.print(nextFields[i][j]);
                if (j != nextFields[i].length) {
                    System.out.print(" \u23A2 ");
                }
            }
            System.out.println();
        }
        printFieldDown();
    }

    static boolean result(String[][] fields) {
        boolean res = false;

        for (int i = 0; i < 3; i++) {  // horizontal test
        if (fields[i][0].equals(fields[i][1]) && fields[i][1].equals(fields[i][2]) && (fields[i][0].equals("\u2715") || fields[i][0].equals("\u2B55"))) {
        System.out.println("   WINNER - " +fields[i][1]);
        res = true;
        }
        }
        for (int i = 0; i < 3; i++) {  // vertical test
        if (fields[0][i].equals(fields[1][i]) && fields[1][i].equals(fields[2][i]) &&  (fields[0][i].equals("\u2715") || fields[0][i].equals("\u2B55"))) {
        System.out.println("   WINNER - " + fields[0][i]);
        res = true;
        }
        }
        if (fields[0][0].equals(fields[1][1]) && fields[1][1].equals(fields[2][2]) &&  (fields[0][0].equals("\u2715") || fields[0][0].equals("\u2B55"))) {
        System.out.println("   WINNER - " + fields[0][0]);
        res = true;

        } else if (fields[0][2].equals(fields[1][1]) && fields[1][1].equals(fields[2][0]) &&  (fields[0][2].equals("\u2715") || fields[0][2].equals("\u2B55"))) {
        System.out.println("   WINNER - " + fields[0][2]);
        res = true;

        }else {
            if (!res) {
                int a = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (fields[i][j].equals("\u2715") || fields[i][j].equals("\u2B55")) {
                            a = a + 1;
                            if (a == 9) {
                                System.out.println((" ") + (char) 27 + "[31mThe GAME has END! \n     \u2715 DRAW \u2B55" + (char) 27 + "[0m");
                                res = true;
                            }
                        }
                    }
                }

            }

        }
        return res;
    }
}


