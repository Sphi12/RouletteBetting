package masivian.test.roulettebetting.model;

public class AddRouletteResponse {

	private String idRoulette;
	private GenericResponse genericResponse;

	public AddRouletteResponse(String idRoulette, GenericResponse genericResponse) {
		super();
		this.idRoulette = idRoulette;
		this.genericResponse = genericResponse;
	}

	@Override
	public String toString() {
		return "AddRouletteResponse [idRoulette=" + idRoulette + ", genericResponse=" + genericResponse + "]";
	}

	public String getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}

	public GenericResponse getGenericResponse() {
		return genericResponse;
	}

	public void setGenericResponse(GenericResponse genericResponse) {
		this.genericResponse = genericResponse;
	}

}
