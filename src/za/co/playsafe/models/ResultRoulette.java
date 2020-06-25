package za.co.playsafe.models;

public class ResultRoulette {

	private String player;
	private String betType;
	private String outcome;
	private Double winnings;
	private Double amountBet;

	public ResultRoulette() {
		super();
	}

	public ResultRoulette(String player, String betType, String outcome, Double winnings, Double amountBet) {
		super();
		this.player = player;
		this.betType = betType;
		this.outcome = outcome;
		this.winnings = winnings;
		this.amountBet = amountBet;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getBetType() {
		return betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Double getWinnings() {
		return winnings;
	}

	public void setWinnings(Double winnings) {
		this.winnings = winnings;
	}

	public Double getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(Double amountBet) {
		this.amountBet = amountBet;
	}

	@Override
	public String toString() {
		return "ResultRoulette [player=" + player + ", betType=" + betType + ", outcome=" + outcome + ", winnings="
				+ winnings + ", amountBet=" + amountBet + "]";
	}

}
