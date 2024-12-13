import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
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
        System.out.println(newDisk);
            arrangeDisk(newDisk);
        System.out.println(newDisk);
            calculatChecksum(newDisk);

        System.out.println(checkSum);
    }

    public static void arrangeDisk(ArrayList<String> line){
        int indexFront = 0;
        int indexLast = line.size()-1;

        while(indexFront < indexLast){
            //Find antal i træk
            int count = 1;
            String character = "";
            for (int i = indexLast; i > 0; i--) {
                character = line.get(i);
                if (!character.equals(".") && character.equals(line.get(i-1))){
                    count++;
                } else break;
            }
            //Finder blanke i streg.

                for (int i = 0; i < line.size(); i++) {
                    if (character.equals(".")){
                        break;
                    }
                    int numberOfBlanks = 0;
                    while (i < indexLast && line.get(i).equals(".")){
                        numberOfBlanks++;
                        i++;
                    }
                    if (numberOfBlanks >= count){
                        int blankStart = i-numberOfBlanks;
                        rearrange(blankStart, indexLast, count, line);
                        //System.out.println(line);
                        break;
                    }
                }
            indexLast -= count;
            indexFront = line.indexOf(".");
        }

    }

    public static void rearrange(int startIndex, int slutIndex, int count, ArrayList<String> line){
        //startIndex + count -1
        slutIndex = slutIndex - count +1;

        String number = line.get(slutIndex);
        for (int i = startIndex; i < startIndex+ count; i++) {
            line.set(i, number);
        }
        for (int i = slutIndex; i < slutIndex+count; i++) {
            line.set(i, ".");
        }
    }

    public static void calculatChecksum(ArrayList<String> line){
        int fileID = 0;
        for (String s : line) {
            if (!s.equals(".")){
                BigInteger newBig = new BigInteger(s);
                BigInteger multimplier = new BigInteger(String.valueOf(fileID));
                checkSum = checkSum.add(newBig.multiply(multimplier));
            }
            fileID++;
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
