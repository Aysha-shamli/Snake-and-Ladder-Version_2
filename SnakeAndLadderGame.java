package snakeAndLadder;
import java.util.Random;

public class SnakeAndLadderGame {
    public static void main(String[] args) {

        System.out.println("The game starts at position 0 ");
        System.out.println("The size of the game board is 100 ");

        playGame();
    }
    static void playGame() {
        int player1Position = 0;
        int player2Position = 0;
        int boardSize = 100;
        int diceRollCount = 0;

        while (player1Position != boardSize && player2Position != boardSize) {
            for (int a = 0; a <= 1; a++) {
                int playersTurn = a;
                if (playersTurn == 0) {
                    System.out.println("Player 1's turn");
                    diceRollCount++;
                    int diceRoll = rollDice();
                    int option = checkOption();
                    player1Position = movePlayer(player1Position, option, diceRoll);
                    System.out.println("After rolling a " + diceRoll + ", player 1 is at position " + player1Position);

                    if (player1Position < 0) {
                        System.out.println("Player 1's position is less than 0. Resetting to 0.");
                        player1Position = 0;
                    } else if (player1Position > boardSize) {
                        System.out.println("Player 1's position is above 100. Staying at the previous position.");
                        player1Position -= diceRoll; // Move the player back to the previous position
                    } else if (player1Position == boardSize) {
                        System.out.println("Congratulations! Player 1 won the Game!!!");
                        System.out.println("Number of times the dice was played to win the game: " + diceRollCount);
                        return;
                    }
                } else {
                    int diceRoll = rollDice();
                    int option = checkOption();
                    player2Position = movePlayer(player2Position, option, diceRoll);
                    System.out.println("After rolling a " + diceRoll + ", player 2 is at position " + player2Position);
                    diceRollCount++;

                    if (player2Position < 0) {
                        System.out.println("Player 2's position is less than 0. Resetting to 0.");
                        player2Position = 0;
                    } else if (player2Position > boardSize) {
                        System.out.println("Player 2's position is above 100. Staying at the previous position.");
                        player2Position -= diceRoll; // Move the player back to the previous position
                    } else if (player2Position == boardSize) {
                        System.out.println("Congratulations! Player 2 won the Game!!!");
                        System.out.println("Number of times the dice was played to win the game: " + diceRollCount);
                        return;
                    }
                }
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
                break;
        }
        return playerPosition;
    }
}
