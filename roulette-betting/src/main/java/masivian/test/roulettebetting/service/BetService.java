package masivian.test.roulettebetting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.repository.BetRepository;

@Service
public class BetService implements IBetService {

	@Autowired
	private BetRepository repository;
	@Value("${masivian.message.successful:null}")
	private String messageSuccessful;
	@Value("${masivian.code.successful:null}")
	private String codeSuccessful;

	public List<Bet> getBets() {
		return repository.getAllBets();
	}

	public GenericResponse createBet(Bet bet) {
		GenericResponse response = new GenericResponse(messageSuccessful, codeSuccessful);
		if (bet != null) {
			response = repository.createBet(bet);
		}
		return response;
	}

	public void deleteBet(Bet bet) {
		if (bet != null) {
			repository.deleteBet(bet);
		}
	}
}
