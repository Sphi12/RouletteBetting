package masivian.test.roulettebetting.repository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;

@Component
public class ClientRedisRepository {

	@Autowired
	@Qualifier("redisClient")
	private RedisTemplate<String, Object> redisTemplateClient;
	@Value("${masivian.code.failed:01}")
	private String codeFailed;
	@Value("${masivian.message.failed:null}")
	private String messageFailed;
	@Value("${masivian.message.successful:null}")
	private String messageSuccessful;
	@Value("${masivian.code.successful:null}")
	private String codeSuccessful;
	@Value("${masivian.redis.hash.clients:null}")
	private String hashClients;

	public GenericResponse createClient(Client client) {
		if (client != null) {
			String json = new JSONObject(client).toString();
			redisTemplateClient.opsForHash().put(hashClients, client.getIdClient(), json);
			return new GenericResponse(messageSuccessful, codeSuccessful);
		}
		return new GenericResponse(messageFailed, codeFailed);
	}

	public Client getClient(String idClient) throws JsonSyntaxException {
		if (idClient != null) {
			Gson gson = new Gson();
			String productJson = (String) redisTemplateClient.opsForHash().get(hashClients, idClient);
			if (productJson != null && !productJson.isEmpty()) {
				Client client = gson.fromJson(productJson, Client.class);
				if (client == null) {
					return client;
				} else {
					return client;
				}
			}
		}
		return null;
	}

	public void modifyClient(Client client) {
		if (client != null) {
			redisTemplateClient.opsForHash().delete(hashClients, client.getIdClient());
			String json = new JSONObject(client).toString();
			redisTemplateClient.opsForHash().put(hashClients, client.getIdClient(), json);
		}
	}

}
