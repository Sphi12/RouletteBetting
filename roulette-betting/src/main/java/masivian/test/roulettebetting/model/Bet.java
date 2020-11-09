package masivian.test.roulettebetting.model;

public class Bet {

	private String id;
	private int number;
	private String colour;
	private Roulette roulette;
	private double betAmount;
	private Client client;

	public Bet(String id, int number, String colour, Roulette roulette, double betAmount, Client client) {
		super();
		this.id = id;
		this.number = number;
		this.colour = colour;
		this.roulette = roulette;
		this.betAmount = betAmount;
		this.client = client;
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

	public Client getIdClient() {
		return client;
	}

	public void setIdClient(Client idClient) {
		this.client = idClient;
	}

	@Override
	public String toString() {
		return "Bet [id=" + id + ", number=" + number + ", colour=" + colour + ", roulette=" + roulette + ", betAmount="
				+ betAmount + ", client=" + client + "]";
	}

}
