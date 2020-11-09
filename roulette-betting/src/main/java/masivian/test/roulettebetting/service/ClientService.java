package masivian.test.roulettebetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.repository.ClientRedisRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	ClientRedisRepository repository;

	public GenericResponse createClient(Client client) {
		GenericResponse response = new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL, APIConstants.CODE_SUCCESSFUL);
		if (client != null) {
			response = repository.createClient(client);
		}
		return response;
	}

	public Client getClient(String id) {
		if (id != null) {
			Client client = repository.getClient(id);
			return client;
		}
		return null;
	}

	public void modifyClient(Client client) {
		if (client != null) {
			repository.modifyClient(client);
		}
	}
}
