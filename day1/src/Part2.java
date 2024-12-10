import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Part2 {

    public static int totalDistance = 0;
        public static void main(String[] args) throws FileNotFoundException {
            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();

            File file = new File("src/input");
            Scanner scanner = new Scanner(file);

            int line = 0;
            while (scanner.hasNextInt()){
                if (line % 2 == 0){
                    array1.add(scanner.nextInt());
                }
                else {
                    array2.add(scanner.nextInt());
                }
                line++;
            }
            sortArray(array2);


            for (Integer integer : array1) {
                findOccurrence(integer, array2);
            }
            System.out.println(totalDistance);
        }
        public static void findOccurrence(int intToFind, ArrayList<Integer> array){
            int count = 0;
            for (Integer i : array) {
               if (i == intToFind){
                   count++;
               }
            }
            totalDistance += count*intToFind;
        }


        public static void sortArray(ArrayList<Integer> array){
            boolean isSwapped = true;

            while (isSwapped){
                isSwapped = false;
                for (int i = 0; i < array.size()-1; i++) {
                    if (array.get(i) > array.get(i+1)){
                        swap(array, i, i+1);
                        isSwapped = true;
                    }
                }
            }
        }
    }

