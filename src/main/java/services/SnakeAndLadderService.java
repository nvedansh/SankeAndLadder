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
    private Queue<Player> playersQueue;
    private boolean isGameCompleted;

    public SnakeAndLadderService(int boardSize){
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.playersQueue = new LinkedList<Player>();
        this.isGameCompleted = false;
    }

    public void setPlayersQueue(List<Player> players){
        HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player: players){
            playersQueue.add(player);
            playerPieces.put(player.getId(), 0);
        }
        snakeAndLadderBoard.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes){
        snakeAndLadderBoard.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders){
        snakeAndLadderBoard.setLadders(ladders);
    }

    public void startGame(){
        int place = 1;
        while (playersQueue.size() != 0){
            int totalDiceValue = DiceService.roll(); //1-6
            Player p = playersQueue.poll(); //[p2,p3,p4]
            int newPosition = movePlayer(p, totalDiceValue);
            System.out.println(p.getName()+" "+newPosition);
            if(newPosition > snakeAndLadderBoard.getSize()){
                System.out.println(p.getId()+" "+p.getName()+" has won the game at place: "+place);
                place++;
//                isGameCompleted = true;
            }
            else{
                playersQueue.add(p); //[p2,p3,p4,p1]
            }
        }
    }

    private int movePlayer(Player p, int totalDiceValue) {
        HashMap<String, Integer> playerPieces = snakeAndLadderBoard.getPlayerPieces();
        int oldPosition = playerPieces.get(p.getId());
        int newPosition = oldPosition + totalDiceValue;
        int boardSize = this.snakeAndLadderBoard.getSize();
        if(newPosition <= boardSize){
            //still the game is on
            newPosition = getModifiedPositionAfterSnakeAndLadder(p, newPosition);
        }
        playerPieces.put(p.getId(), newPosition);
        return newPosition;
    }

    private int getModifiedPositionAfterSnakeAndLadder(Player p, int newPosition) {
        for(Snake snake: snakeAndLadderBoard.getSnakes()){
            if(snake.getStartPosition() == newPosition){
                newPosition = snake.getEndPosition();
                System.out.println("Snake movement from "+ snake.getStartPosition()
                        + " to "+ snake.getEndPosition()+" for player: "+p.getName());
                break;
            }
        }
        for (Ladder ladder: snakeAndLadderBoard.getLadders()){
            if(ladder.getStartPosition() == newPosition){
                newPosition = ladder.getEndPosition();
                System.out.println("Ladder movement from "+ ladder.getStartPosition()
                        + " to "+ ladder.getEndPosition()+" for player: "+p.getName());
                break;
            }
        }
        return newPosition;
    }

}
