import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Part1And2 {
    private static int trailheadCount = 0;
    private static ArrayList<Position> positions = new ArrayList<>();
    private static ArrayList<Position> endPositions = new ArrayList<>();

    private static ArrayList<ArrayList<Position>> startAndEnd = new ArrayList<>();

    private static int xLimit = 0;
    private static int yLimit = 0;

    public static void main(String[] args) throws IOException {
        List<String> lines = getInput();

        int x = 0;
        int y = 0;

        xLimit = lines.getFirst().length()-1;
        yLimit = lines.size()-1;

        for (String line : lines) {
            for (String Char : line.split("")) {
                int number = Integer.parseInt(Char);
                positions.add(new Position(x, y, number));
                x++;
            }
            y++;
            x = 0;
        }

        for (Position position : positions) {
            if (position.getNumber() == 0){
                checkTrailHead(0, position, position);
            }
        }
        System.out.println("Part 1 answer: " + startAndEnd.size());
        System.out.println("Part 2 answer: " + trailheadCount);
    }
    public static void checkTrailHead(int number, Position position, Position startPosition){
        if (number == 9){
            trailheadCount++;
            addToPositionsVisited(position, startPosition);
            return;
        }

        //UP
        Position newPos = getPosition(position.getX(), position.getY()-1);
        if (newPos != null && newPos.getNumber() == number +1){
            checkTrailHead(number +1, newPos, startPosition);
        }

        //DOWN
        newPos = getPosition(position.getX(), position.getY()+1);
        if (newPos != null && newPos.getNumber() == number +1){
            checkTrailHead(number +1, newPos,startPosition);
        }

        //LEFT
        newPos = getPosition(position.getX()-1, position.getY());
        if (newPos != null && newPos.getNumber() == number +1){
            checkTrailHead( number+1, newPos, startPosition);
        }

        //RIGHT
        newPos = getPosition(position.getX()+1, position.getY());
        if (newPos != null && newPos.getNumber() == number +1){
            checkTrailHead(number +1, newPos, startPosition);
        }
    }

    private static void addToPositionsVisited(Position endPosition, Position startPosition){
        for (ArrayList<Position> positionArrayList : startAndEnd) {
            if (positionArrayList.contains(startPosition) && positionArrayList.contains(endPosition)){
                return;
            }
        }
            startAndEnd.add(new ArrayList<>(Arrays.asList(startPosition, endPosition)));
    }

    public static Position getPosition(int x, int y){
        if (x > xLimit || x < 0 || y > yLimit || y < 0){
            return null;
        }
        for (Position position : positions) {
            if (position.getX() == x && position.getY() == y){
                return position;
            }
        }
        System.out.println("FEJL");
        return null;
    }

    public static ArrayList<String> getInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input"));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}
