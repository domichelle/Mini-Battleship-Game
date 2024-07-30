package project4_mini_battleship_game;

import java.util.Random;
import java.util.Scanner;

public class Michelle_Do_Project4 {

		// Programmer: Michelle Do
		// Class Section: 3311.0w1
	
		/*
		 Implement a Java program that simulates the board game Battleship.
		 The game is played in a “sea”, a 1-dimensional array, and the ship is randomly located in the sea. 
		 The user guesses locations (array index values) in attempts to find (hit) the ship.
		 When all ship index values are guessed (all hit), the ship is sunk, and the game is over.
		 */
	
	public static void main(String[] args) {
		
		// Declare vars
		int ship1;
		int sum = 0;
		int guess; // Where the player's guess is stored
		int guesses = 0; // Running total of guesses as the game progresses
		
		// Declare arrays
		int[] sea = new int[20]; // Ship location is shown by 1's, all others 0's
		int[] hit = new int[20]; // Starts with all 0's, and converts to 1's as ship is hit
		
		// Instantiate objects
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		// Set the location of the ship
		
		// 1) Create random int value using rand.nextInt() method, range of 0-16 (assign to ship 1)
		ship1 = rand.nextInt(17);
		sea[ship1] = 1;
		
		// 2) Add 3 index values next to the random index value from step 1
		for(int i = 0; i < 4; i++) {
			int j = ship1 + i; // j = the remaining index values of the ship to ship1
			if(j < sea.length) {
				sea[j] = 1;
			} 
			else {
				break;
			}
		}
		
		// Print both the sea array and the hit array using prtArray() method
		prtArray(sea, "Sea");
		prtArray(hit, "Hit");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println();
		
		// Start loop for the guesser (suggestion: use a while loop)
		while(sum < 4) {
			// Prompt for a guess
			System.out.print("Enter a number from 0-19 to guess where the battleship is: ");
			guess = scan.nextInt();
			guesses++;
			// Evaluate if a guess is a hit or not
			if(sea[guess] == 1) {
				System.out.println("HIT!");
				hit[guess] = 1;
			}
			else {
				System.out.println("MISS!");
			}
			sum = 0; // Reinitialize sum
			for(int i = 0; i < hit.length; i++) {
				sum = sum + hit[i];
			}
		}
		
		// Print sunk and other messages for sinking the ship
		System.out.println();
		System.out.println("SUNK!");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println();
					
		// Print both the sea array and the hit array using prtArray() method
		prtArray(sea, "Sea");
		prtArray(hit, "Hit");
		System.out.println();
		System.out.println("Congratulations on sinking the battleship!");
		System.out.println("It took you " + guesses + " guesses.");
		
		scan.close();

	} // End of main method, class methods below
	
	// prtArray
	public static void prtArray(int[] a, String aName) {
		System.out.print(aName + ": ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
