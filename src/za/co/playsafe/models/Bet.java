package za.co.playsafe.models;

public class Bet {

	private Double value;
	private Integer betNumber;

	private BetType betType;

	public Bet() {
		super();
	}

	public Bet(BetType betType, Double value, Integer betNumber) {
		super();
		this.betType = betType;
		this.value = value;
		this.betNumber = betNumber;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(Integer betNumber) {
		this.betNumber = betNumber;
	}

	@Override
	public String toString() {
		return "Bet [betType=" + betType + ", value=" + value + ", betNumber=" + betNumber + "]";
	}

}
