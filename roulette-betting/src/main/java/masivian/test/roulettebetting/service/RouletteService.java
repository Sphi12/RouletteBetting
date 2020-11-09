package masivian.test.roulettebetting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.model.AddRouletteResponse;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.model.Roulette;
import masivian.test.roulettebetting.repository.RouletteRedisRepository;
import masivian.test.roulettebetting.util.Util;

@Service
public class RouletteService implements IRouletteService {

	@Autowired
	private RouletteRedisRepository repository;
	@Autowired
	private Util util;
	@Value("${masivian.message.successful:null}")
	private String messageSuccessful;
	@Value("${masivian.code.successful:null}")
	private String codeSuccessful;
	@Value("${masivian.roulette.open.state:null}")
	private String openState;
	@Value("${masivian.code.failed:01}")
	private String codeFailed;
	@Value("${masivian.message.failed:null}")
	private String messageFailed;
	@Value("${masivian.message.notfound:null}")
	private String messageFailedNotFound;
	@Value("${masivian.roulette.closed.state:null}")
	private String closedState;

	public List<Roulette> getAllRoulettes() {
		return repository.getAllRoulettes();
	}

	public GenericResponse rouletteOpening(String id) {
		GenericResponse response = new GenericResponse(messageSuccessful, codeSuccessful);
		if (id != null) {
			Roulette roulette = findRouletteById(id);
			if (roulette != null) {
				roulette.setRouletteStatus(openState);
				repository.modifyRoulette(roulette);
				return response;
			}
			response.setCodeResponsse(codeFailed);
			response.setMessageResponse(messageFailedNotFound);
		}

		return response;
	}
	
	public GenericResponse closedRoulette(String id) {
		GenericResponse response = new GenericResponse(messageSuccessful, codeSuccessful);
		if (id != null) {
			Roulette roulette = findRouletteById(id);
			if (roulette != null) {
				roulette.setRouletteStatus(closedState);
				repository.modifyRoulette(roulette);
				return response;
			}
			response.setCodeResponsse(codeFailed);
			response.setMessageResponse(messageFailedNotFound);
		}

		return response;
	}


	public Roulette findRouletteById(String id) {
		Roulette roulette = new Roulette();
		if (id != null) {
			roulette = repository.getRoulette(id);
			return roulette;
		}

		return null;
	}

	public AddRouletteResponse addRoulette() {
		GenericResponse genericResponse = null;
		String id = util.generateId(6);
		try {
			Roulette roulette = new Roulette();
			roulette.setIdRoulette(id);
			roulette.setRouletteStatus(closedState);
			genericResponse = repository.saveRoulette(roulette);
			if (genericResponse.getCodeResponsse().equals(codeSuccessful)) {
				return new AddRouletteResponse(id, genericResponse);
			}
		} catch (Exception exception) {
			return new AddRouletteResponse(null, new GenericResponse(exception.getMessage(), codeFailed));
		}

		return new AddRouletteResponse(null, new GenericResponse(messageFailed, codeFailed));
	}
}
