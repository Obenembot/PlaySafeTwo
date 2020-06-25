package za.co.playsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import za.co.playsafe.models.BetType;
import za.co.playsafe.models.Player;
import za.co.playsafe.models.ResultRoulette;
import za.co.playsafe.service.RouletteService;

public class Test {

	static List<Player> players = new ArrayList<>();

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Player player = null;
		RouletteService rouletteService = new RouletteService();
		ResultRoulette resultRoulette = new ResultRoulette();
		Map<String, Player> betPlayers = new TreeMap<>();
		SplittableRandom random = new SplittableRandom();
		List<ResultRoulette> resultRoulettes = new CopyOnWriteArrayList<>();

		int playerNumber = 0, number = 0, chioce = 0, betType = 0, betValue = 0, control = 0;

		// SPin Value Captured
		int spin = random.nextInt(1, 36);

		players = rouletteService.laodFile("PLAYERS.txt");

		do {

			System.out.println();
			while (players.size() != playerNumber) {
				player = Test.players.get(playerNumber);

				System.out.println(playerNumber++ + ". " + player.getName());
			}
			playerNumber = 0;
			System.out.print("\nSelect Player You Want To Bet: ");

			chioce = scanner.nextInt();

			if (chioce >= players.size()) {
				System.out.println("Inavid Player Name {try between 0 - " + players.stream().count() + "}");
				continue;
			}
			player = rouletteService.validatePlayer(chioce);

			System.out.print("\nSelect bet Value/Amount : R");
			betValue = scanner.nextInt();

			System.out.println("\n");
			System.out.print(
					"1. " + BetType.EVEN + "\n2. " + BetType.ODD + "\n3. " + BetType.NUMBER + "\nSelect Bet Type: ");

			betType = scanner.nextInt();

			if (betType == 3) {
				System.out.print("Place your bet on number(1-36): ");
				number = scanner.nextInt();
			}

			// Placing Bet
			resultRoulette = rouletteService.placeBet(spin, betValue, betType, number, player);

			// Print Data Here
			scanner.nextLine();

			// Checking Statistics per player
			rouletteService.checkPlayersStatistics(rouletteService.resultRoulettes, player);

			control++;
			player = null;
		} while (players.size() > control);

		betPlayers = rouletteService.betPlayers;

		//rouletteService.addingOldReecord(betPlayers);
		
		resultRoulettes = rouletteService.resultRoulettes;

		System.out.println("\nNumber: " + spin + " 				Output 1");
		line();
		printHeader1();
		control = 0;

		while (resultRoulettes.size() > control) {

			printRow1(resultRoulettes.get(control).getPlayer(), resultRoulettes.get(control).getBetType(),
					resultRoulettes.get(control).getOutcome(), resultRoulettes.get(control).getWinnings());
			control++;
		}

		System.out.println("\n\n				  Output 2");
		line();
		printHeader2();
		control = 0;

		for (String key : betPlayers.keySet()) {
			printRow2(betPlayers.get(key).getName(), betPlayers.get(key).getTotalWin(),
					betPlayers.get(key).getTotalBet());
		}
	}

	static void line() {
		System.out.printf("----------------------------------------------------------------------------------\n");
	}

	static void printHeader1() {
		System.out.printf("%-20s \t %-20s \t %-15s \t %-15s \n", "Player", "Bet ", "Outcome", "Winnings");
	}

	static void printRow1(String player, String bet, String outcome, double winnings) {
		System.out.printf("%-23s  %-23s  %-23s  %-23s \n", player, bet, outcome, winnings);
	}

	static void printHeader2() {
		System.out.printf("%-20s \t %-20s \t %-20s \n", "Player", "Total Win ", "Total Bet");
	}

	static void printRow2(String player, Double totalWIns, double totalBet) {
		System.out.printf("%-23s  %-23s  %-23s  \n", player, totalWIns, totalBet);
	}

}
