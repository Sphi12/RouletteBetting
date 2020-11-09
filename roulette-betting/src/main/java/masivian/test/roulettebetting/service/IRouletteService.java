package masivian.test.roulettebetting.service;

import java.util.List;

import masivian.test.roulettebetting.model.AddRouletteResponse;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.model.Roulette;

public interface IRouletteService {

	public AddRouletteResponse addRoulette();

	public GenericResponse rouletteOpening(String id);

	public Roulette findRouletteById(String id);

	public List<Roulette> getAllRoulettes();

	public GenericResponse closedRoulette(String id);
}
