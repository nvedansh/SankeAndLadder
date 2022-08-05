package services;

import models.Ladder;
import models.Player;
import models.Snake;
import models.SnakeAndLadderBoard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//queue = [p1,p2,p3,p4]
//queue = [p2,p3,p4,p1]
//queue = [p3,p4,p1,p2]

public class SnakeAndLadderService {
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int numberOfPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;

    public SnakeAndLadderService(int boardSize){
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<Player>();
        this.isGameCompleted = false;
    }

    public void setPlayers(List<Player> players){
        HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player: players){
            this.players.add(player);
            playerPieces.put(player.getId(), 0);
            //Each of the player will start at 0th position;
        }
        snakeAndLadderBoard.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes){
        snakeAndLadderBoard.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders){
        snakeAndLadderBoard.setLadders(ladders);
    }

    public int getPosition(Player p){
        return this.snakeAndLadderBoard.getPlayerPieces().get(p.getId());
    }

    public void startGame(){
        while (!isGameCompleted){
            int totalDiceValue = DiceService.roll();
            Player p = this.players.poll();
            movePlayer(p, totalDiceValue);
            System.out.println(p.getName()+" "+getPosition(p));
            if(hasPlayerWon(p)){
                System.out.println(p.getId()+" "+p.getName()+" has won the game");
                isGameCompleted = true;
            }
            this.players.add(p);
        }
    }

    private boolean hasPlayerWon(Player p) {
        HashMap<String, Integer> playerPieces =
                this.snakeAndLadderBoard.getPlayerPieces();
        return playerPieces.get(p.getId()) > this.snakeAndLadderBoard.getSize();
    }

    private void movePlayer(Player p, int totalDiceValue) {
        HashMap<String, Integer> playerPieces =
            this.snakeAndLadderBoard.getPlayerPieces();
        int oldPosition = playerPieces.get(p.getId());
        int newPosition = oldPosition + totalDiceValue;
        int boardSize = this.snakeAndLadderBoard.getSize();
        if(newPosition <= boardSize){
            newPosition = getModifiedPositionAfterSnakeAndLadder(newPosition);
        }
        playerPieces.put(p.getId(), newPosition);
    }

    private int getModifiedPositionAfterSnakeAndLadder(int newPosition) {
        for(Snake snake: this.snakeAndLadderBoard.getSnakes()){
            if(snake.getStartPosition() == newPosition){
                newPosition = snake.getEndPosition();
                System.out.println("Snake movement from "+ snake.getStartPosition()
                        + " to "+ snake.getEndPosition());
                break;
            }
        }
        for (Ladder ladder: this.snakeAndLadderBoard.getLadders()){
            if(ladder.getStartPosition() == newPosition){
                newPosition = ladder.getEndPosition();
                System.out.println("Ladder movement from "+ ladder.getStartPosition()
                        + " to "+ ladder.getEndPosition());
                break;
            }
        }
        return newPosition;
    }

}
