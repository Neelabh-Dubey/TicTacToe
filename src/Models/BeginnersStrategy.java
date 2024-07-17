package Models;

public class BeginnersStrategy implements LevelStrategy{
    @Override
    public Coordinates nextMove(Board board) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board.getBoardMatrix().get(i).get(j) == null)return new Coordinates(i, j);
            }
        }
        return null;
    }
}
