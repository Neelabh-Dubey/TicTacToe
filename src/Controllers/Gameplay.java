package Controllers;

import Models.BotLevel;
import Models.Coordinates;
import Models.Game;
import Models.Player;

import java.util.List;
import java.util.Scanner;

public class Gameplay {
    Scanner scanner;
    Game game;

    private int move;

    public Gameplay(){
        this.game = new Game();
        this.scanner = new Scanner(System.in);
        this.move = 0;
    }
    public void start(){
        System.out.print("Enter board size- ");
        int n = scanner.nextInt();
        game.addBoard(n);
        scanner.nextLine();

        for(int i = 0; i < 2; i++){
            System.out.println("Enter player type- H for human and B for Bot");
            String playerType = scanner.nextLine();
            if(playerType.equals("H")){
                addHumanPlayer();
            }
            else{
                addBotPlayer();
            }
        }
        System.out.println();
        System.out.println("Now, lets play- ");
        play();
    }

    private boolean isValidMove(Coordinates coordinates){
        int x = coordinates.getX();
        int y = coordinates.getY();
        List<List<Integer>>boardMatrix = game.getBoard().getBoardMatrix();
        if(x < 0 || x >= boardMatrix.size() || y < 0 || y >= boardMatrix.size() || boardMatrix.get(x).get(y) != null){
            System.out.println("Invalid Moves");
            return false;
        }
        return true;
    }

    private void play(){
        game.printPlayerList();
        int n = game.getBoard().getBoardMatrix().size();
        while(move < n*n){
            int idx = move % 2;
            Player player = game.getPlayers().get(idx);
            System.out.println("------------------------------");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(game.getBoard().getBoardMatrix().get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            Coordinates coordinates;
            do{
                coordinates = player.move(game.getBoard());
            }while (!isValidMove(coordinates));
            game.updateBoard(coordinates, player);
            if(game.isWinner(coordinates)){
                System.out.println(player.getName() + " has won the games!");
                return;
            }
            move++;
        }
        System.out.println("Draw!");
    }
    private void addHumanPlayer(){
        System.out.print("Enter the player name- ");
        String name = scanner.nextLine();
        game.addPlayer(name);
    }
    private void addBotPlayer(){
        System.out.println("Add bot level- A for advanced and B for Beginners");
        String level = scanner.nextLine();
        if(level.equals("A"))game.addBot(BotLevel.ADVANCED);
        else game.addBot(BotLevel.BEGINNER);
    }
}
