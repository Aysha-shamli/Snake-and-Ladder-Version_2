package snakeAndLadder;
import java.util.Random;
public class SnakeAndLadderGame {
    public static void main(String[] args) {
        int playerPosition = 0;
        int BoardSize = 100;
        System.out.println("The game start at position: "+playerPosition);
        System.out.println("The size of the game board is: "+BoardSize);

        playGame(playerPosition, BoardSize);
    }
    static void playGame(int playerPosition,int BoardSize) {
        while (playerPosition < BoardSize) {
            int diceRoll = rollDice();
            int option = checkOption();
            playerPosition = movePlayer(playerPosition, option, diceRoll);
            System.out.println("After rolling a " + diceRoll + ", the player is at position " + playerPosition);
            if (playerPosition < 0) {
                System.out.println("Player's position is less than 0. Resetting to 0.");
                playerPosition = 0;
            }
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
    static int checkOption() {
        Random random = new Random();
        return random.nextInt(3); // Generates a random number between 0 and 2 for No Play, Ladder, or Snake
    }
    static int movePlayer(int playerPosition, int option, int diceRoll) {
        switch (option) {
            case 0:
                System.out.println("No Play. Player stays at the same position.");
                break;
            case 1:
                System.out.println("Ladder! Player moves ahead by " + diceRoll + " positions.");
                return playerPosition + diceRoll;
            case 2:
                System.out.println("Snake! Player moves behind by " + diceRoll + " positions.");
                return playerPosition - diceRoll;
            default:
                System.out.println("Invalid option.");
                return playerPosition;
        }
        return playerPosition;
    }
}