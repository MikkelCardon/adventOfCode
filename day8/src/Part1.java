import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static int xLimit;
    public static int yLimit;

    public static void main(String[] args) throws IOException {
        List<String> lines = getInput();

        ArrayList<Position> positions = new ArrayList<>();
        int x = 0;
        int y = 0;
        xLimit = lines.getFirst().length()-1;
        yLimit = lines.size()-1;

        for (String line : lines) {
            for (String Char : line.split("")) {
                positions.add(new Position(Char, x, y));
                x++;
            }
            y++;
            x = 0;
        }
        printMap(positions);
        for (Position position : positions) {
            if (!position.character.equals(".") && !position.character.equals("#")){
                findNextOccurance(positions, position);
            }
        }
        printMap(positions);
        System.out.println(Position.resonantCount);
    }

    public static void findNextOccurance(ArrayList<Position> positions, Position position){
        int startIndex = positions.indexOf(position);

        for (int i = startIndex+1; i < positions.size(); i++) {
            Position current = positions.get(i);
            if (current.character.equals(position.character)){
                int xDif = current.xPosition - position.xPosition;
                int yDif = current.yPosition - position.yPosition;
                //Første punkt
                addAntinode(current, xDif, yDif, positions);

                //Andet punkt
                xDif = position.xPosition - current.xPosition;
                yDif = position.yPosition - current.yPosition;
                addAntinode(position, xDif, yDif, positions);
            }
        }

    }
    public static void addAntinode(Position position, int xDif, int yDif, ArrayList<Position> positions){

        //While index x og y er inden for ramme, så lav antinode
        if (position.xPosition + xDif >= 0 && position.xPosition + xDif <= xLimit &&
                position.yPosition + yDif >= 0 && position.yPosition + yDif <= yLimit){
            Position newPos = null;
            for (Position rotationPos : positions) {
                if (rotationPos.xPosition == position.xPosition + xDif && rotationPos.yPosition == position.yPosition + yDif){
                    newPos = rotationPos;
                }
            }
            if (newPos != null && !newPos.antinode){
                newPos.setAntinode(true);

                if (newPos.character.equals(".")){
                    newPos.setCharacter("#");
                }
            }
        }
    }

    public static void printMap(ArrayList<Position> positions){
        for (Position position : positions) {
            System.out.print(position);
            if (position.xPosition == xLimit){
                System.out.println();
            }
        }
    }

    public static List<String> getInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Input"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}
