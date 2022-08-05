import models.Player;
import models.Snake;
import services.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Snake> snakes = new ArrayList<>();
        snakes.add(s1);

        game.setPlayers(players);
        game.setSnakes(snakes);

        game.startGame();
    }
}
