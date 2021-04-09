package adventure;

import java.util.Random;
import java.util.Scanner;

public class HeroAdventure {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Random randNum = new Random();
		
		String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int potionHeathAmount = 30;
		int healthPotionDropChance = 50;
		
		boolean running = true;
		
		System.out.println("Welcome to the dungeon");
		
		GAME:
		while(running) {
			System.out.println("-----------------------------------------");
			
			int enemyHealth = randNum.nextInt(maxEnemyHealth);
			String enemy = enemies[randNum.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = randNum.nextInt(attackDamage);
					int damageTaken = randNum.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
				} else if(input.equals("2")) {
					
				} else {
					
				}
				
			} 
			
		}
	}

}
