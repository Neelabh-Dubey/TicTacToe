package Strategy;

import Models.Board;
import Models.Coordinates;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinning(Coordinates coordinates, Board board) {
//        System.out.println("Row Winning- ");
        List<List<Integer>> matrix = board.getBoardMatrix();
        int colSize = matrix.get(coordinates.getX()).size();
        int idOfPlayerMoving = matrix.get(coordinates.getX()).get(coordinates.getY());
        for(int j = 0; j < colSize; j++){
//            System.out.println(matrix.get(coordinates.getX()).get(j) + " " + idOfPlayerMoving + " " + j);
            if(matrix.get(coordinates.getX()).get(j) == null || matrix.get(coordinates.getX()).get(j) != idOfPlayerMoving)return false;
        }
        return true;
    }
}
