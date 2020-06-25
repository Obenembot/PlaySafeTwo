package za.co.playsafe.models;

public class Player {

	private String name;
	private Double totalWin;
	private Double totalBet;
	
	private Bet bet;

	public Player() {
		super();
	}

	public Player(String name, Double totalWin, Double totalBet, Bet bet) {
		super();
		this.name = name;
		this.totalWin = totalWin;
		this.totalBet = totalBet;
		this.bet = bet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalWin() {
		return totalWin;
	}

	public void setTotalWin(Double totalWin) {
		this.totalWin = totalWin;
	}

	public Double getTotalBet() {
		return totalBet;
	}

	public void setTotalBet(Double totalBet) {
		this.totalBet = totalBet;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", totalWin=" + totalWin + ", totalBet=" +
	totalBet + ", bet=" + bet + "]";
	}
	
	
}
