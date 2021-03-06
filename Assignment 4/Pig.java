//Che-Chi (Jack) Liu
//V00850558

/*
A dice roll game that user has the option to keep rolling. Computer only gets 4 rolls.
If 1 is rolled, the turn switches and player or computer receives 0 point that round.
Each roll's number is added to the final score. First to 100 points wins the game.
*/

import java.util.Random;
import java.util.Scanner;

public class Pig {
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Pig. Beginning the game...\n");
		gameLoop();
	}
	
	public static int diceRoll(Random rand) {
		int diceNumber = 1 + rand.nextInt(6);
		return diceNumber;
	}
	
	public static int playerTurn(Scanner input, Random rand) {
		int playerScore = 0;
		int diceNumber = diceRoll(rand);
		
		if(diceNumber != 1) {
			playerScore = playerScore + diceNumber;
			System.out.println("You rolled a " + diceNumber + 
					". Your score so far is " + playerScore + "\n" +
					"Do you want to roll again (yes or no)");

			while(diceNumber != 1) {
				String response = input.nextLine();
				if(response.equalsIgnoreCase("yes")) {
					diceNumber = diceRoll(rand);
					
					if(diceNumber == 1) {
						playerScore = 0;
						System.out.println("uh oh, you rolled a 1!" + "\n" + 
								"Your turn is over and you get 0 points this round.\n");
						break;
					}
					else {
						playerScore = playerScore + diceNumber;
						System.out.println("You rolled a " + diceNumber + 
							". Your score so far is " + playerScore + "\n" +
							"Do you want to roll again (yes or no)");
					}
				}
				else if(response.equalsIgnoreCase("no")) {
					System.out.println("Ending your turn with a score of " + playerScore+"\n");
					break;
				}
				else {
					System.out.println("Please enter yes or no.");
				}
			}	
		}
		else if(diceNumber == 1) {
			playerScore = 0;
			System.out.println("uh oh, you rolled a 1!" + "\n" + 
					"Your turn is over and you get 0 points this round.\n");
		}
		
		return playerScore;
	}
	
	public static int computerTurn(Random rand) {
		int computerScore = 0;
		int diceNumber;
		
		for(int i = 0; i < 4; i++) {
			diceNumber = diceRoll(rand);
			
			if(diceNumber == 1) {
				computerScore = 0;
				System.out.println("The computer rolled a 1,"
						+ " ending its turn with a score of 0 this round.");
				break;
			}
			else{
				computerScore = computerScore + diceNumber;
				System.out.println("The computer rolled a "+ diceNumber + 
						". It's total score this turn is " + computerScore + ".");
			}
		}
		
		System.out.println("Ending computer's turn with a score of " + computerScore);
		return computerScore;
	}
	
	public static void gameLoop() {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		boolean gamePlay = true;						
		int playerScore = 0;
		int computerScore = 0;
		
		while(gamePlay) {
			playerScore+=playerTurn(input, rand);
			computerScore+=computerTurn(rand);

			System.out.println("The scores at the end of current round are: \nPlayer: " + playerScore + "\tComputer: " + computerScore + "\n\n");
			
			if(playerScore >= 100) {
				System.out.println("Congratulations, you win!!");
				gamePlay = false;
			}
			
			if(computerScore >= 100) {
				System.out.println("Sorry, you lose!!");
				System.out.println("Computer wins!!");
				gamePlay = false;
			}
		}
	}
}
