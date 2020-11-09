package masivian.test.roulettebetting.service;

import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;

public interface IBetService {

	public GenericResponse createBet(Bet bet);
}
