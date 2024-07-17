import Controllers.Gameplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world, Lets start the game- ");
        Gameplay gameplay = new Gameplay();
        gameplay.start();
        System.out.println("Completed!");
    }
}