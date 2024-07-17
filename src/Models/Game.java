package Models;

import Strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player>players;
    private Board board;

    private final List<WinningStrategy> winningStrategies;

    public Game(){
        players = new ArrayList<>();
        winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new LRDiagonalWinningStrategy());
        winningStrategies.add(new RLDiagonalWinningStrategy());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void printPlayerList(){
        players.forEach(player -> {
            System.out.println(player.getName() + " " + player.getId() + " " +player.getSymbol());
        });
    }

    public Board getBoard() {
        return board;
    }

    GameState gameState;

    private int id = 0;

    public void addPlayer(String name){
        Symbol symbol = allotSymbol();
        Player p = new HumanPlayer(name, id, symbol);
        players.add(p);
        id++;
    }

    private Symbol allotSymbol(){
        int i = players == null ? 0 : players.size();
        return switch (i) {
            case 0 -> Symbol.CIRCLE;
            case 1 -> Symbol.CROSS;
            default -> null;
        };
    }

    public void addBot(BotLevel level){
        Symbol symbol = allotSymbol();
        BotPlayer bot = new BotPlayer(level, id, symbol);
        players.add(bot);
    }

    public void addBoard(int size){
        board = new Board(size);
    }

    public void startGame(){
        if(gameState == GameState.INPROGRESS){
            System.out.println("Game is already in progress!");
            return;
        }
        if(gameState == GameState.NOTSTARTED || gameState == null){
            gameState = GameState.INPROGRESS;
            System.out.println("Game has been started!");
            return;
        }
        System.out.println("Game is finished!");
    }

    public void updateBoard(Coordinates coordinates, Player player){
        int x = coordinates.getX();
        int y = coordinates.getY();
        board.getBoardMatrix().get(x).set(y, player.getId());
    }

    public boolean isWinner(Coordinates coordinates){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.isWinning(coordinates, board))return true;
        }
        return false;
    }

}
