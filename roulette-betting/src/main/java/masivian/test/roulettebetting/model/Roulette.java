package masivian.test.roulettebetting.model;

public class Roulette {

	private String idRoulette;
	private String rouletteStatus;

//	public Roulette(String idRoulette, String rouletteStatus) {
//		super();
//		this.idRoulette = idRoulette;
//		this.rouletteStatus = rouletteStatus;
//		this.createDate = new Date();
//	}

	/**
	 * @return the idRoulette
	 */
	public String getIdRoulette() {
		return idRoulette;
	}

	/**
	 * @param idRoulette the idRoulette to set
	 */
	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}

	/**
	 * @return the rouletteStatus
	 */
	public String getRouletteStatus() {
		return rouletteStatus;
	}

	/**
	 * @param rouletteStatus the rouletteStatus to set
	 */
	public void setRouletteStatus(String rouletteStatus) {
		this.rouletteStatus = rouletteStatus;
	}

	@Override
	public String toString() {
		return "Roulette [idRoulette=" + idRoulette + ", rouletteStatus=" + rouletteStatus + "]";
	}
}
