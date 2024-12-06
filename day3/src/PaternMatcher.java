import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaternMatcher {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInput();
        int result = 0;

        for (String line : lines) {

            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            Matcher m = pattern.matcher(line);

            while(m.find()){
                int value1 = Integer.parseInt(m.group(1));
                System.out.println(value1);
                int value2 = Integer.parseInt(m.group(2));
                System.out.println(value2);
                result+= value1*value2;
            }
        }
        System.out.println(result);
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
