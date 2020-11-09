package masivian.test.roulettebetting.model;

public class Bet {

	private String id;
	private int number;
	private String colour;
	private Roulette roulette;
	private double betAmount;
	private Client client;
	private String result;

	public Bet(String id, int number, String colour, Roulette roulette, double betAmount, Client client,
			String result) {
		super();
		this.id = id;
		this.number = number;
		this.colour = colour;
		this.roulette = roulette;
		this.betAmount = betAmount;
		this.client = client;
		this.result = result;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Roulette getRoulette() {
		return roulette;
	}

	public void setRoulette(Roulette roulette) {
		this.roulette = roulette;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	@Override
	public String toString() {
		return "Bet [id=" + id + ", number=" + number + ", colour=" + colour + ", roulette=" + roulette + ", betAmount="
				+ betAmount + ", client=" + client + ", result=" + result + "]";
	}

}
