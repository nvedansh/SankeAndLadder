package models;

public class Snake {
    private int startPosition;
    private int endPosition;

    public Snake(int startPosition, int endPosition){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    //getter functions
    public int getStartPosition(){
        return startPosition;
    }

    public int getEndPosition(){
        return endPosition;
    }

}
