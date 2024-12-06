import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static int totalCount;

    public static void main(String[] args) throws IOException {
        List<String> strings = getInput();

        for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.get(i).length(); j++) {
                    String string1 = "";
                    String string2 = "";

                    if (i < strings.size()-2 && j < strings.get(i).length()-2){
                        string1+= strings.get(i).charAt(j);
                        string1+= strings.get(i+1).charAt(j+1);
                        string1+= strings.get(i+2).charAt(j+2);

                        string2+= strings.get(i).charAt(j+2);
                        string2+= strings.get(i+1).charAt(j+1);
                        string2+= strings.get(i+2).charAt(j);
                        chechText(string1, string2);
                    }
                }
        }
        System.out.println(totalCount);
    }

    public static void chechText(String text1, String text2){
        if ((text1.equals("MAS")||text1.equals("SAM")) && (text2.equals("MAS")||text2.equals("SAM"))){
            totalCount++;
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
