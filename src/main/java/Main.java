import models.Ladder;
import models.Player;
import models.Snake;
import services.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        int boardSize = 100;
        SnakeAndLadderService game = new SnakeAndLadderService(boardSize);

        Player p1 = new Player("Atul");
        Player p2 = new Player("Vinay");
        Player p3 = new Player("Ajay");
        Player p4 = new Player("Aditya");

        List<Player> players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);


        Snake s1 = new Snake(53, 45);
        Snake s2 = new Snake(11, 4);
        Snake s3 = new Snake(69, 42);
        Snake s4 = new Snake(99, 3);
        List<Snake> snakes = new ArrayList<>();
        snakes.add(s1);
        snakes.add(s2);
        snakes.add(s3);
        snakes.add(s4);

        Ladder l1 = new Ladder(8, 13);
        Ladder l2 = new Ladder(21, 55);
        Ladder l3 = new Ladder(6, 51);
        Ladder l4 = new Ladder(43, 82);

        List<Ladder> ladders = new ArrayList<Ladder>();
        ladders.add(l1);
        ladders.add(l2);
        ladders.add(l3);
        ladders.add(l4);

        game.setPlayersQueue(players);
        game.setSnakes(snakes);
        game.setLadders(ladders);

        game.startGame();

    }
    //game = {board, isCompleted=true, Queue<Players>}
}
