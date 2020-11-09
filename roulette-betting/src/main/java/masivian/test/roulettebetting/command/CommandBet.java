package masivian.test.roulettebetting.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CommandBet {

	@NotNull
	private String idRoulette;
	@Min(0)
	@Max(36)
	private int number;
	private String colour;
	@NotNull
	@Max(10000)
	private double amount;

	public String getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
