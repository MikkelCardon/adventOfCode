import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<BigInteger> array = getInput();

        for (int times = 0; times < 75; times++) {
            for (int i = 0; i < array.size(); i++) {
                BigInteger currentNumber = array.get(i);
                int lengthOfNumber = String.valueOf(currentNumber).length();
                if (currentNumber.equals(BigInteger.ZERO)){
                    array.set(i, BigInteger.ONE);
                }
                else if(lengthOfNumber % 2 == 0){
                    splitNumbers(lengthOfNumber, array, i);
                    i++;
                } else{
                    array.set(i, currentNumber.multiply(new BigInteger(String.valueOf(2024))));
                }

            }
            System.out.println(array.size());
        }
        //System.out.println(array);
        System.out.println(array.size());
    }

    public static void splitNumbers(int length, ArrayList<BigInteger> arrayList, int index){
        String number = String.valueOf(arrayList.get(index));
        int middle = length / 2;
        BigInteger int1 = new BigInteger(number.substring(0, middle));
        BigInteger int2 = new BigInteger(number.substring(middle));

        arrayList.set(index, int1);
        if (arrayList.size() == index+1){
            arrayList.add(int2);
        } else {
            arrayList.add(index+1, int2);
        }
    }

    public static ArrayList<BigInteger> getInput() throws IOException {
        Scanner scanner = new Scanner(new File("src/input"));
        ArrayList<BigInteger> line = new ArrayList<>();

        while (scanner.hasNext()){
            line.add(new BigInteger(scanner.next()));
        }
        return line;
    }
}
