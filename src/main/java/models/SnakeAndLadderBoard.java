package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnakeAndLadderBoard {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private HashMap<String, Integer> playerPieces;
    //Key: ID of the player, Value: Integer position of the player

    public SnakeAndLadderBoard(int size){
        this.size = size;
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.playerPieces = new HashMap<String, Integer>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public HashMap<String, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(HashMap<String, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
