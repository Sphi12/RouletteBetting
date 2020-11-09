package masivian.test.roulettebetting.service;

import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;

public interface IClientService {

	public GenericResponse createClient(Client client);

	public Client getClient(String id);

	public void modifyClient(Client client);
}
