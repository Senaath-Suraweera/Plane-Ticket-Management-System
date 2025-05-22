import java.lang.reflect.Array;

public class Seats {

    private static int[] A = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] B = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] C = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] D = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    public int[] getA() {
        return A;
    }

    public void setA(int[] a) {
        A = a;
    }

    public int[] getB() {
        return B;
    }

    public void setB(int[] b) {
        B = b;
    }

    public int[] getC() {
        return C;
    }

    public void setC(int[] c) {
        C = c;
    }

    public int[] getD() {
        return D;
    }

    public void setD(int[] d) {
        D = d;
    }

    public void setSeat(int row,int indexInput){
        int index = indexInput - 1;
        switch (row){
            case 0:
                A[index] = 1;
                break;
            case 1:
                B[index] = 1;
                break;
            case 2:
                C[index] = 1;
                break;
            case 3:
                D[index] = 1;
                break;
            default:
                System.out.println("Invalid row number entered: from Seats.java");
        }
    }

    public void deleteSeat(int row,int indexInput){
        int index = indexInput - 1;
        switch (row){
            case 0 -> A[index] = 0;
            case 1 -> B[index] = 0;
            case 2 -> C[index] = 0;
            case 3 -> D[index] = 0;
            default -> System.out.println("Invalid row number entered: from Seats.java");
        }
    }

    public int getSeat(int row,int indexInput){
        //-1 return for invalid seat number
        int index = indexInput - 1;
        switch (row){
            case 0:
                return A[index];
            case 1:
                return B[index];
            case 2:
                return C[index];
            case 3:
                return D[index];
            default:
                System.out.println("Invalid row number entered");
                return -1;
        }
    }

    public int[] findFirstAvailableSeat(){
        //In the first row
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                return new int[] {0,i};
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) {
                return new int[] {1,i};
            }
        }
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                return new int[] {2,i};
            }
        }
        for (int i = 0; i < D.length; i++) {
            if (D[i] == 0) {
                return new int[] {3,i};
            }
        }
        return null;
    }

    public void displaySeats(){
        System.out.println("Seats: ");
        System.out.println("    1  2  3  4  5  6  7  8  9  10 11 12 13 14");
        System.out.print("A: ");
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                System.out.print(" X ");
            }else{
                System.out.print(" O ");
            }

        }
        System.out.println();
        System.out.print("B: ");
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                System.out.print(" X ");
            }else{
                System.out.print(" O ");
            }

        }
        System.out.println();
        System.out.print("C: ");
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 1) {
                System.out.print(" X ");
            }else{
                System.out.print(" O ");
            }

        }
        System.out.println();
        System.out.print("D: ");
        for (int i = 0; i < D.length; i++) {
            if (D[i] == 1) {
                System.out.print(" X ");
            }else{
                System.out.print(" O ");
            }

        }
        System.out.println();
    }
}
