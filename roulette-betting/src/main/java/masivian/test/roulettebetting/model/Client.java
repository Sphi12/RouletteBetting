package masivian.test.roulettebetting.model;

import javax.validation.constraints.NotNull;

public class Client {

	@NotNull
	private String idClient;
	@NotNull
	private double totalAmount;

	public Client(@NotNull String idClient, @NotNull double totalAmount) {
		super();
		this.idClient = idClient;
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", totalAmount=" + totalAmount + "]";
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
