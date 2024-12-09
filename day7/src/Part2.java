import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static List<String> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        list = getInput();
        BigInteger calibrationSum = BigInteger.ZERO;

        for (String line : list) {
            Pattern pattern = Pattern.compile("(\\d+):");
            Matcher matcher = pattern.matcher(line);
            BigInteger result = BigInteger.ZERO;
            while (matcher.find()) {
                result = new BigInteger(matcher.group(1));
            }
            String[] parts = line.split(":");
            ArrayList<BigInteger> numbers = new ArrayList<>();

            if (parts.length > 1) {
                try (Scanner scanner = new Scanner(parts[1])) {
                    while (scanner.hasNextBigInteger()) {  // Use nextBigInteger for BigInteger
                        numbers.add(scanner.nextBigInteger());
                    }
                }
            }
            if (calibrationResult(result, numbers, 1, numbers.getFirst())){
                calibrationSum = calibrationSum.add(result);
            }
        }
        System.out.println("calibrationSum = " + calibrationSum);
    }

    public static boolean calibrationResult(BigInteger result, ArrayList<BigInteger> numbers, int index, BigInteger count) {
        if (index == numbers.size()){
            return count.equals(result);
        }
        BigInteger sum1 = count.add(numbers.get(index));
        BigInteger sum2 = count.multiply(numbers.get(index));

        String newNumb = String.valueOf(count) + String.valueOf(numbers.get(index));
        Long newLong = Long.parseLong(newNumb);
        BigInteger sum3 = BigInteger.valueOf(newLong);

        index++;
        boolean check1 = calibrationResult(result, numbers, index, sum1);
        boolean check2 = calibrationResult(result, numbers, index, sum2);
        boolean check3 = calibrationResult(result, numbers, index, sum3);
        return check1 || check2 || check3;
    }


    public static List<String> getInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}
