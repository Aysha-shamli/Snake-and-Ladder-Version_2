package snakeAndLadder;
import java.util.Random;
public class SnakeAndLadderGame {
    public static void main(String[] args) {
        int playerPosition = 0;
        int BoardSize = 100;
        System.out.println("The game start at position: "+playerPosition);
        System.out.println("The size of the game board is: "+BoardSize);
        System.out.println("The Ladder Positions on GameBoard: [2, 8, 20, 32, 41, 74, 82, 85]");
        System.out.println("The Snake Positions on GameBoard: [29, 38, 47, 53, 62, 86, 92, 97]");

        playGame(playerPosition, BoardSize);
    }
    static void playGame(int playerPosition,int BoardSize) {
        while (playerPosition < BoardSize) {
            int diceRoll = rollDice();
            playerPosition = playerPosition + diceRoll;
            System.out.println("After rolling a " + diceRoll + ", the player is at position " + playerPosition);

            if (playerPosition == BoardSize) {
                System.out.println("Congratulations! You won the Game!!!");
                break;
            }
        }
    }
    static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generates a random number between 1 and 6
    }
}
