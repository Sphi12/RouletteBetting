package masivian.test.roulettebetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.repository.ClientRedisRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	ClientRedisRepository repository;
	@Value("${masivian.message.successful:null}")
	private String messageSuccessful;
	@Value("${masivian.code.successful:null}")
	private String codeSuccessful;

	public GenericResponse createClient(Client client) {
		GenericResponse response = new GenericResponse(messageSuccessful, codeSuccessful);
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
