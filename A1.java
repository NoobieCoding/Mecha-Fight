import java.io.File;
import java.util.Scanner;

public class A1 {
	static Scanner input = new Scanner(System.in);
	static int runNum = 2, command = -99;
	static String attackName = "";
	static boolean firstWin = false, secondWin = false, isDraw = false;

	public static void main(String[] args) {
		System.out.println("       Welcome to Mecha fight!!!       ");
		System.out.println("----------------------------------------");

		System.out.println("                Rule                    ");
		System.out.println("1. Both player toss the dice and who has more score plays first.(turn based system).");
		System.out.println(
				"2. In each player turn, that player can choose 1 action from \n-Attack(each attack consumes energy) -Charge(restore 300 energy) -Defence(half the damage recieved for 1 turn).");
		System.out.println("3. Player that has his/her energy less or equals than zero, lost the game.");
		System.out.println("----------------------------------------");

		System.out.print("Input first player name: ");
		Player player1 = new Player(input.nextLine());
		System.out.print("Input second player name: ");
		Player player2 = new Player(input.nextLine());

		System.out.println("----------------------------------------");
		setUp(player1, player2);
		System.out.println("----------------------------------------");

		System.out.println("Let's roll!!!!!!!!!!!!!!!!!!");

		roll(player1, player2);

		play(player1, player2);

		System.out.println("\nGame end\n");
		if (player1.getMech().getEnergy() <= 0 && player2.getMech().getEnergy() <= 0) {
			System.out.println("Draw");
			isDraw = true;
		} else if (player1.getMech().getEnergy() <= 0) {
			System.out.println(player2.getName() + " wins the game");
			secondWin = true;
		} else {
			System.out.println(player1.getName() + " wins the game");
			firstWin = true;
		}
		updateLog();
	}

	public static void roll(Player player1, Player player2) {
		rollEach(player1);
		rollEach(player2);

		while (player1.getScore() == player2.getScore()) {
			System.out.println("----------------------\nRoll again");
			rollEach(player1);
			rollEach(player2);
		}
		System.out.println();
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " plays first");
			System.out.println("----------------------------------------");
			player1.setIsTurn(true);
		} else {
			System.out.println(player2.getName() + " plays first");
			System.out.println("----------------------------------------");
			player2.setIsTurn(true);
		}
	}

	public static void setUp(Player player1, Player player2) {
		Weapon[] weaArr1 = { new Weapon("Beam", 500, 200), new Weapon("Punch", 300, 100),
				new Weapon("Kick", 600, 600) };
		Mecha mech1 = new Mecha("XX-1", "Xenogear", 171, 2000, 1500, weaArr1);
		setEach(player1, mech1, weaArr1);
		System.out.println("----------------------------------------");

		Weapon[] weaArr2 = { new Weapon("Aerod", 700, 500), new Weapon("Rod", 450, 120), new Weapon("Kick", 300, 200) };
		Mecha mech2 = new Mecha("SL-1", "Vierge", 150, 2100, 1600, weaArr2);
		setEach(player2, mech2, weaArr2);
	}

	public static void play(Player player1, Player player2) {
		while (player1.getMech().getEnergy() > 0 && player2.getMech().getEnergy() > 0) {
			if (player1.getIsTurn()) {
				playEach(player1, player2);
			}
			if (player2.getIsTurn()) {
				playEach(player2, player1);
			}
			command = -99;
			if (player1.getIsTurn()) {
				player1.setIsTurn(false);
				player2.setIsTurn(true);
				player2.getMech().defenceEnd();
			} else if (player2.getIsTurn()) {
				player2.setIsTurn(false);
				player1.setIsTurn(true);
				player1.getMech().defenceEnd();
			}
		}
	}

	public static void rollEach(Player player) {
		System.out.println(player.getName() + " rolls");
		System.out.println(player.rollDice());
	}

	public static void setEach(Player player, Mecha mech, Weapon[] weaArr) {
		System.out.println("Set up " + player.getName() + " mech....");
		player.setMech(mech);
		System.out.println("-" + mech.getName() + "\n-" + mech.getCode() + "\n-weight: " + mech.getWeight()
				+ "\n-speed: " + mech.getSpeed() + "\n-energy: " + mech.getEnergy());

	}

	public static void playEach(Player player1, Player player2) {
		System.out.println(player1.getName() + "'s turn");
		System.out.println("1.attack\n2.charge\n3.defence");
		System.out.print("Choose command(1,2,3): ");
		while (command != 1 && command != 2 && command != 3) {
			command = Integer.parseInt(input.nextLine());
			if (command != 1 && command != 2 && command != 3)
				System.out.print("Wrong command input again: ");
		}
		if (command == 1) {
			System.out.print("Choose your weapon: ");
			attackName = input.nextLine();
			player1.getMech().attack(attackName, player2.getMech());
		} else if (command == 2) {
			player1.getMech().charge();
		} else if (command == 3) {
			player1.getMech().defence();
		}
		System.out.println("Current " + player1.getName() + "'s energy = " + player1.getMech().getEnergy());
		System.out.println("Current " + player2.getName() + "'s energy = " + player2.getMech().getEnergy());
		System.out.println("end of " + player1.getName() + " turn.");
		System.out.println("----------------------------------------");
	}

	public static void updateLog() {
		try {
			File infile = new File("log.txt");
			if (isDraw) {

			} else if (firstWin) {

			} else {

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
