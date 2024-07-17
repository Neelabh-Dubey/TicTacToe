package Strategy;

import Models.Board;
import Models.Coordinates;

import java.util.List;

public class LRDiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinning(Coordinates coordinates, Board board) {
//        System.out.println("LR Winning Strategy- ");
        List<List<Integer>> matrix = board.getBoardMatrix();
        int rowSize = matrix.size();
        int idOfPlayerMoving = matrix.get(coordinates.getX()).get(coordinates.getY());
        for(int i = 0; i < rowSize; i++){
//            System.out.println(matrix.get(i).get(i) + " " + idOfPlayerMoving);
            if(matrix.get(i).get(i) == null || matrix.get(i).get(i)!= idOfPlayerMoving)return false;
        }
        return true;
    }
}
