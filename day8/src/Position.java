public class Position {
    String character;
    int xPosition;
    int yPosition;
    boolean antinode = false;

    public static int resonantCount;

    public Position(String character, int x, int y) {
        this.character = character;
        this.xPosition = x;
        this.yPosition = y;
    }



    @Override
    public String toString() {
        return character;
    }

    public String getCharacter() {
        return character;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setAntinode(boolean antinode) {
        this.antinode = antinode;
        resonantCount++;
    }
}
