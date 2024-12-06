import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static int totalCount;

    public static void main(String[] args) throws IOException {
        List<String> strings = getInput();

        for (int i = 0; i < strings.size(); i++) {
            Pattern patternXMAS = Pattern.compile("XMAS");
            Pattern patternSAMX = Pattern.compile("SAMX");

            Matcher xmas = patternXMAS.matcher(strings.get(i));
            Matcher samx = patternSAMX.matcher(strings.get(i));
            while (xmas.find() || samx.find()){
               totalCount++;
            }
            try{
                for (int j = 0; j < strings.get(i).length(); j++) {
                    String text = "";
                    if (i < strings.size()-3){
                        text += strings.get(i).charAt(j);
                        text += strings.get(i+1).charAt(j);
                        text += strings.get(i+2).charAt(j);
                        text += strings.get(i+3).charAt(j);
                        chechText(text);
                    }

                    if (i < strings.size()-3 && j < strings.get(i).length()-3){
                        text = "";
                        text += strings.get(i).charAt(j);
                        text += strings.get(i+1).charAt(j+1);
                        text += strings.get(i+2).charAt(j+2);
                        text += strings.get(i+3).charAt(j+3);
                        chechText(text);
                    }

                    text = "";
                    if (j >= 3 && i < strings.size()-3){
                        text += strings.get(i).charAt(j);
                        text += strings.get(i+1).charAt(j-1);
                        text += strings.get(i+2).charAt(j-2);
                        text += strings.get(i+3).charAt(j-3);
                       chechText(text);
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println(ex.getMessage());
            }
            catch (StringIndexOutOfBoundsException ex){
                System.out.println(ex.getMessage());
            }
            catch (IndexOutOfBoundsException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(totalCount);
    }

    public static void chechText(String text){
        if (text.equals("XMAS")||text.equals("SAMX")){
            totalCount++;
            System.out.println(text);
        }
    }

    public static List<String> getInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        return list;
    }
}
