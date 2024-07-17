package Strategy;

import Models.Board;
import Models.Coordinates;

import java.util.List;

public class RLDiagonalWinningStrategy implements WinningStrategy{

    @Override
    public boolean isWinning(Coordinates coordinates, Board board) {
//        System.out.println("RL Winning Strategy- ");
        List<List<Integer>> matrix = board.getBoardMatrix();
        int colSize = matrix.size();
        int idOfPlayerMoving = matrix.get(coordinates.getX()).get(coordinates.getY());
        for(int i = 0; i < colSize; i++){
//            System.out.println(matrix.get(i).get(colSize-1-i) + " " + idOfPlayerMoving);
            if(matrix.get(i).get(colSize-1-i) == null || matrix.get(i).get(colSize-1-i) != idOfPlayerMoving)return false;
        }
        return true;
    }
}
