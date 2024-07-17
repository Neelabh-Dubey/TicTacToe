package Models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    HumanPlayer(String name, int id, Symbol symbol){
        super(name, id, PlayerType.HUMAN, symbol);
    }

    @Override
    public Coordinates move(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates, like- 0 2");
        String[] arr = scanner.nextLine().split(" ");
        return new Coordinates(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
}
