package masivian.test.roulettebetting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.constants.APIConstants;
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

	public List<Roulette> getAllRoulettes() {
		return repository.getAllRoulettes();
	}

	public GenericResponse rouletteOpening(String id) {
		GenericResponse response = new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL, APIConstants.CODE_SUCCESSFUL);
		if (id != null) {
			Roulette roulette = findRouletteById(id);
			if (roulette != null) {
				roulette.setRouletteStatus(APIConstants.OPEN_STATE);
				repository.modifyRoulette(roulette);
				return response;
			}
			response.setCodeResponsse(APIConstants.CODE_FAILED);
			response.setMessageResponse(APIConstants.MESSAGE_NOT_FOUND);
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
			roulette.setRouletteStatus(APIConstants.CLOSED_STATUS);
			genericResponse = repository.saveRoulette(roulette);
			if (genericResponse.getCodeResponsse().equals(APIConstants.CODE_SUCCESSFUL)) {
//				List<Roulette> rouletteFind = repository.getAllRoulettes();
//				System.out.println("RULETA GUARDADA " + rouletteFind.toString());
				return new AddRouletteResponse(id, genericResponse);
			}
		} catch (Exception exception) {
			return new AddRouletteResponse(null, new GenericResponse(exception.getMessage(), APIConstants.CODE_FAILED));
		}
		return new AddRouletteResponse(null,
				new GenericResponse(APIConstants.MESSAGE_FAILED, APIConstants.CODE_FAILED));
	}
}
