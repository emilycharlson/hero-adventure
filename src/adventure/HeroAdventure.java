package adventure;

import java.util.Random;
import java.util.Scanner;

public class HeroAdventure {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random randNum = new Random();

		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int potionHeathAmount = 30;
		int healthPotionDropChance = 50;

		boolean running = true;
		System.out.println("##########################");
		System.out.println("# WELCOME TO THE DUNGEON #");
		System.out.println("##########################");

		GAME: 
		while (running) {
		System.out.println("-----------------------------------------");

		int enemyHealth = randNum.nextInt(maxEnemyHealth);
		String enemy = enemies[randNum.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");

		while (enemyHealth > 0) {
			System.out.println("\tYour HP: " + health);
			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
			System.out.println("\n\tWhat would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Drink health potion");
			System.out.println("\t3. Run!");

			String input = in.nextLine();
			if (input.equals("1")) {
					int damageDealt = randNum.nextInt(attackDamage);
					int damageTaken = randNum.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					health -= damageTaken;

					System.out.println("\t> You struck the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You received " + damageTaken + " in retaliation.");

					if (health < 1) {
						System.out.println("\tYou have taken too much damage, you are too weak to continue.");
						break;
					}

				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						health += potionHeathAmount;
						numHealthPotions--;
						System.out.println("\tYou drank a health potion. Your health has improved by "
								+ potionHeathAmount + "." + "\n\t> You now have " + health + " HP." + "\n\t? You have "
								+ numHealthPotions + " health potions left. \n");
					} else {
						System.out.println("\t> You have no health potions left! Defeat enemies for more potions.");
					}

				} else if (input.equals("3")) {
					System.out.println("\tYou ran away from the " + enemy + "!");
					continue GAME;

				} else {
					System.out.println("\tInvalid command.");
				}

			};

			if (health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}

			System.out.println("-----------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left.");

			if (randNum.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
			}

			System.out.println("-----------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit the dungeon ");

			String response = in.nextLine();

			while (!response.equals("1") && !response.equals("2")) {
				System.out.println("Invalid command!");
				response = in.nextLine();
			}
			if (response.equals("1")) {
				System.out.println("You continue on your adventure!");

			} else if (response.equals("2")) {
				System.out.println("You exit the dungeon, successful from your dungeon");
				break;
			}
			
		}; //running

		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");

	} 

}
