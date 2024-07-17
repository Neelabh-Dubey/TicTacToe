package Strategy;

import Models.Board;
import Models.Coordinates;

public interface WinningStrategy {
    public boolean isWinning(Coordinates coordinates, Board board);
}
