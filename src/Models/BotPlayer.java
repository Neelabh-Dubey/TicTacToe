package Models;

public class BotPlayer extends Player{
    private LevelStrategy levelStrategy;
    BotPlayer(BotLevel level, int id, Symbol symbol){
        super(level == BotLevel.BEGINNER ? "Karen" : "Jarvis", id, PlayerType.BOT, symbol);
        levelStrategy = level == BotLevel.BEGINNER ? new BeginnersStrategy() : new AdvancedStrategy();
    }

    @Override
    public Coordinates move(Board board) {
        return levelStrategy.nextMove(board);
    }
}
