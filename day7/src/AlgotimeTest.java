import java.util.ArrayList;

public class AlgotimeTest {
    public static void main(String[] args) {
        calbrationResult(11);
    }

    public static void calbrationResult(int size){
        int xStart = -1;
        int xSlut = -1;

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size-1; i++) {
                if (i >= xStart && i <= xSlut){
                    System.out.print("*");

                }else System.out.print("+");
            }
            System.out.println();
            xStart++;
            xSlut++;
        }

        int xUsed = 2;
        xStart = 0;
        xSlut = xUsed-1;

        while (xUsed <= size-1){
            for (int j = 0; j < size-xUsed; j++) {
                for (int i = 0; i < size-1; i++) {
                    if (i >= xStart && i <= xSlut){
                        System.out.print("*");
                    }else System.out.print("+");
                }
                System.out.println();
                xStart++;
                xSlut++;
            }
            xUsed++;
            xStart = 0;
            xSlut = xUsed-1;
        }

    }
}


