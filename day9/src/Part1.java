import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    private static BigInteger checkSum = BigInteger.ZERO;

    public static void main(String[] args) throws IOException {
        ArrayList<String> line = getInput();


            String toAppend;
            ArrayList<String> newDisk = new ArrayList<>();
            int numberToAppend = 0;
            int numberOfTimes;
            for (int i = 0; i < line.size(); i++) {
                numberOfTimes = Integer.parseInt(line.get(i));
                if (i % 2 == 1){
                    toAppend = ".";
                } else {
                    toAppend = String.valueOf(numberToAppend++);
                }
                for (int j = 0; j < numberOfTimes; j++) {
                    newDisk.add(toAppend);
                }
            }
            arrangeDisk(newDisk);
            calculatChecksum(newDisk);

        System.out.println(checkSum);
    }

    public static void arrangeDisk(ArrayList<String> line){
        int index = 0;
        int indexOfLast = line.size();

        while(index < indexOfLast){
            if (line.get(index).equals(".")){
                for (int i = indexOfLast-1; true; i--) {
                    if (!line.get(i).equals(".")){
                        indexOfLast = i;
                        break;
                    }
                }
                line.set(index, line.get(indexOfLast));
                line.set(indexOfLast, ".");
            }
            index++;
        }
    }

    public static void calculatChecksum(ArrayList<String> line){
        int fileID = 0;
        for (String s : line) {
            if (!s.equals(".")){
                BigInteger newBig = new BigInteger(s);
                BigInteger multimplier = new BigInteger(String.valueOf(fileID++));
                checkSum = checkSum.add(newBig.multiply(multimplier));
            }
        }
    }

    public static ArrayList<String> getInput() throws IOException {
        File file = new File("src/Input");
        Scanner scanner = new Scanner(file);
        String input = scanner.nextLine();

        ArrayList<String> line = new ArrayList<>();
        line.addAll(Arrays.asList(input.split("")));
        return line;
    }
}
