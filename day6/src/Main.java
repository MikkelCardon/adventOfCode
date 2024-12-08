import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> list;
    private static int posY;
    private static int posX;
    private static char next;
    private static String direction = "up";

    private static ArrayList<ArrayList<Integer>> visitedPositions = new ArrayList<>();
    private static int totalPositions = 0;

    public static void main(String[] args) throws IOException {
        list = getInput();
        //Get start position
        posY = findStartY(list);
        posX = list.get(posY).indexOf("^");


        while(next != 'x'){
            changePosition();
            if (next == '#'){
                changeDirection();
            }
            else {
                hasPosBeenVisited();
            }
        }

        System.out.println(totalPositions);
    }

    private static void hasPosBeenVisited() {
        boolean beenVisited = false;
        if(visitedPositions != null){
            for (ArrayList<Integer> position : visitedPositions) {
                if (position.get(0) == posX && position.get(1) == posY){
                    beenVisited = true;
                    break;
                }
            }
        }
        if (!beenVisited){
            totalPositions++;
            ArrayList<Integer> newPos = new ArrayList(Arrays.asList(posX, posY));
            visitedPositions.add(newPos);
        }
    }

    public static void changePosition(){
        switch (direction){
            case "up": posY--; break;
            case "right": posX++; break;
            case "down": posY++; break;
            case "left": posX--; break;
        }

        if (posX < 0 || posX >= list.getFirst().length() || posY < 0 || posY >= list.size()){
            next = 'x';
        }
        else {
            next = list.get(posY).charAt(posX);
        }
    }

    public static void changeDirection(){
        switch (direction){
            case "up": direction = "right"; posY++;
            break;
            case "right": direction = "down"; posX--;
            break;
            case "down": direction = "left"; posY--;
            break;
            case "left": direction = "up"; posX++;
            break;
        }
    }


    public static int findStartY(List<String> list){
        for (String line : list) {
            if (line.contains("^")){
                return list.indexOf(line);
            }
        }
        return -1;
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
