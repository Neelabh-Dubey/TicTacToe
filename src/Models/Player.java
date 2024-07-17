package Models;


public abstract class Player {
    private String name;
    private int id;

    private PlayerType playerType;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    Player(String name, int id, PlayerType playerType, Symbol symbol){
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public abstract Coordinates move(Board board);

}
