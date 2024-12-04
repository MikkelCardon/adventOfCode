import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;
import static java.util.Collections.swap;

public class Main {
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
            sortArray(array1);
            sortArray(array2);

            int totalDistance = 0;
            for (int i = 0; i < array1.size(); i++) {
                if (array2.get(i) - array1.get(i) < 0){
                    totalDistance += (array2.get(i) - array1.get(i)) * -1;
                }
                else {
                    totalDistance += array2.get(i) - array1.get(i);
                }
            }

            System.out.println(totalDistance);
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

