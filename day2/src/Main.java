import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int safeReports = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scanner = new Scanner(file);
        
        ArrayList<String> rækkeArray = new ArrayList<>();

        while (scanner.hasNextLine()){
           rækkeArray.add(scanner.nextLine());
        }

        for (String linje : rækkeArray) {
            Scanner scanner1 = new Scanner(linje);
            ArrayList<Integer> arrayListLinje = new ArrayList<>();
            while(scanner1.hasNext()){
               arrayListLinje.add(scanner1.nextInt());
            }

            boolean increase = increaseCheck(arrayListLinje);
            boolean decrease = decreaseCheck(arrayListLinje);

            if (increase || decrease){
                safeReports++;
            }
            System.out.println(safeReports);
        }
    }

    public static boolean increaseCheck(ArrayList<Integer> array){
        for (int i = 0; i < array.size()-1; i++) {
            if (array.get(i) >= array.get(i+1)){
                return false;
            }
            if (array.get(i+1) - array.get(i) > 3 ){
                return false;
            }
        }
        return true;
    }

    public static boolean decreaseCheck(ArrayList<Integer> array){
        for (int i = 0; i < array.size()-1; i++) {
            if (array.get(i) <= array.get(i+1)){
                return false;
            }
            if (array.get(i) - array.get(i+1) > 3){
                return false;
            }
        }
        return true;
    }
}
