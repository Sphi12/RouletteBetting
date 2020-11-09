package masivian.test.roulettebetting.service;

import java.util.List;

import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;

public interface IBetService {

	public GenericResponse createBet(Bet bet);

	public List<Bet> getBets();

	public void deleteBet(Bet bet);
}
