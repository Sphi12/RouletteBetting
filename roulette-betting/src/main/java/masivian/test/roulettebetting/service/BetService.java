package masivian.test.roulettebetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.repository.BetRepository;

@Service
public class BetService implements IBetService {

	@Autowired
	private BetRepository repository;

	public GenericResponse createBet(Bet bet) {
		GenericResponse response = new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL, APIConstants.CODE_SUCCESSFUL);
		if (bet != null) {
			response = repository.createBet(bet);
		}
		return response;
	}
}
