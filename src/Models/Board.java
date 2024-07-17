package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<List<Integer>>boardMatrix;
    Board(int n){
        boardMatrix = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            boardMatrix.add(new ArrayList<>(n));
            int j = 0;
            while(j++ < n)boardMatrix.get(i).add(null);
        }
    }

    public List<List<Integer>> getBoardMatrix() {
        return boardMatrix;
    }
}
