import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static int result;

    public static void main(String[] args) {
        try {
            File file = new File("src/input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                findMul(scanner.next());
            }
            System.out.println(result);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }
    }

    public static void findMul(String text) {
        String textToLookFor = "mul(";

        for (int i = 0; i < text.length() - textToLookFor.length(); i++) {
            String tempText = text.substring(i, i + textToLookFor.length());

            if (tempText.equals(textToLookFor)) {
                try {
                    if (!text.substring(i).contains(")")) {
                        break;
                    }
                        int slutIndex = text.indexOf(")", i);

                        if (slutIndex == -1) {
                            break;
                        }

                        String mulText = text.substring(i, slutIndex + 1);
                        System.out.print(mulText);

                        if (mulText.contains(",") && mulText.contains(")")) {
                            int value1 = 0;
                            int value2 = 0;
                            try {

                                value1 = Integer.parseInt(mulText.substring(4, mulText.indexOf(",")));
                                value2 = Integer.parseInt(mulText.substring(mulText.indexOf(",") + 1, mulText.indexOf(")")));


                                if (value1 != 0 && value2 != 0) {
                                    result += value1 * value2;
                                    System.out.println(" Value added - " + value1 * value2);
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Error parsing values: " + ex.getMessage());
                            }
                        }

                } catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("Index out of bounds: " + ex.getMessage());
                }
            }
        }
    }
}
