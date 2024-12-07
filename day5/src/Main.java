import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.swap;

public class Main {
    private static int middlePageSum;
    private static ArrayList<Integer> int1 = new ArrayList<>();
    private static ArrayList<Integer> int2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> rules = getInput("src/Input-test");
        List<String> lists = getInput("src/lists");

        ArrayList<ArrayList<Integer>> arrayListOfLists = new ArrayList<>();

        //Gets the values from ordering rules
        for (String line : rules) {
            Pattern pattern = Pattern.compile("(\\d+)\\|(\\d+)");
            Matcher m = pattern.matcher(line);
            while(m.find()){
                int1.add(Integer.parseInt(m.group(1)));
                int2.add(Integer.parseInt(m.group(2)));
            }
        }

        for (String line : lists) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] splitNumbers = line.split(",");
            for (String splitNumber : splitNumbers) {
                list.add(Integer.parseInt(splitNumber));
            }
            arrayListOfLists.add(list);
            System.out.println(list);
        }

        for (ArrayList<Integer> arrayListOfList : arrayListOfLists) {
            checkList(arrayListOfList);
        }
        System.out.println(middlePageSum);
//        ArrayList<Integer> orgTest  = new ArrayList<>(Arrays.asList(75,97,47,61,53));
//        System.out.println(orgTest);
//        organizeFalseList(orgTest);
//        System.out.println(orgTest);

    }
    public static void checkList(ArrayList<Integer> list){
        boolean isAccepted = true;
        for (int i = 0; i < int1.size(); i++) {
            if (list.contains(int1.get(i)) && list.contains(int2.get(i))){
                if (list.indexOf(int2.get(i)) < list.indexOf(int1.get(i))){
                    isAccepted = false;
                    //organizeFalseList(list);
                    break;
                }
            }
        }
        if (isAccepted){
            middlePageSum += list.get(list.size() / 2);
        }
    }

//    public static void organizeFalseList(ArrayList<Integer> list){
//        boolean beenSwapped = true;
//        while(beenSwapped){
//            beenSwapped = false;
//
//            for (int i = 0; i < int1.size(); i++) {
//                if (list.contains(int1.get(i)) && list.contains(int2.get(i))){
//                    if (list.indexOf(int2.get(i)) < list.indexOf(int1.get(i))){
//                        int temp = list.get(list.indexOf(int1.get(i)));
//                        list.remove(int1.get(i));
//
//                        if (list.indexOf(int2.get(i)) == list.size()-1){
//                            list.add(temp);
//                            System.out.println(list + "SIDSTE!!");
//                        }
//                        else {
//                            list.add(list.indexOf(int2.get(i))+1, temp);
//                            System.out.println(list + "lægges baefter");
//                        }
//                        beenSwapped = true;
//                    }
//                }
//            }
//        }
//        //Tag midter tal
//    }


    public static List<String> getInput(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}