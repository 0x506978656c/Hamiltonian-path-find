public class HamiltonianSolver extends Thread {
    static char[][] gmatrix; // matrix
    static long[][] result; // results

    public HamiltonianSolver() {
        this.setPriority(Thread.NORM_PRIORITY);
    }

    public void run() {
        Main main = new Main();
        gmatrix = new char[main.Xbound][main.Ybound];
        result = new long[main.Xbound][main.Ybound];
        int i, j;
        for (i = 0; i < (main.Xbound); i++) {
            for (j = 0; j < (main.Ybound); j++) {
                gmatrix[i][j] = 0;
            }

        }
        for (i = 0; i < (main.Xbound); i++) {
            for (j = 0; j < (main.Ybound); j++) {
                if (j >= i) {
                    result[i][j] = 0;
                    traverse(i, j, 0, 0);
                    if (main.distinct) {
                        if (i + 1 == main.Xbound && j + 1 == main.Ybound)
                            System.out.println("For a " + (i + 1) + " x " + (j + 1) + " grid, there are " + result[i][j] + " unique paths");
                    } else {
                        System.out.println("For a " + (i + 1) + " x " + (j + 1) + " grid, there are " + result[i][j] + " unique paths");
                    }
                }
            }
        }
    }

    public void traverse(int c, int r, int i, int j) {

        if (i == c && j == r) {
            gmatrix[i][j] = 5;
            result[i][j] = result[i][j] + 1;
            gmatrix[i][j] = 0;
            return;
        }

        /* try to find paths */
        if (i != 0 && gmatrix[i - 1][j] == 0) { //  behind
            gmatrix[i][j] = 1;
            traverse(c, r, i - 1, j);
        }

        if (j != r && gmatrix[i][j + 1] == 0) { //  up
            gmatrix[i][j] = 2;
            traverse(c, r, i, j + 1);
        }

        if (j != 0 && gmatrix[i][j - 1] == 0) { //  down
            gmatrix[i][j] = 3;
            traverse(c, r, i, j - 1);
        }

        if (i != c && gmatrix[i + 1][j] == 0) { //  right
            gmatrix[i][j] = 4;
            traverse(c, r, i + 1, j);
        }
        gmatrix[i][j] = 0;

    }

}









