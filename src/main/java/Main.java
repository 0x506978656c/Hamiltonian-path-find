public class Main {
    /** Hamiltonian count path solver by ! Pixel
     * Takes the concept from http://www.geekwriter.com/ugrad/cs202/doc/index.html and improves it
     */


    /**
     * @Xbound the size of the horizontal side
     * @Ybound the size of the vertical side
     * @distinct boolean to either include all iterations or only the final size inputted
     *
     */
    public static int Xbound = 5;
    public static int Ybound = 5;
    public static boolean distinct = true;

    public static void main(String[] args) {
       new HamiltonianSolver().start();
    }


}
