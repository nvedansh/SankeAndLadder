package models;

public class Ladder {
    private int startPosition;
    private int endPosition;

    public Ladder(int startPosition, int endPosition){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition(){
        return startPosition;
    }

    public int getEndPosition(){
        return endPosition;
    }

}
