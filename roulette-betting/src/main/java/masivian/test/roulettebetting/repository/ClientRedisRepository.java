package masivian.test.roulettebetting.repository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.constants.RedisConstants;
import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;

@Component
public class ClientRedisRepository {

	@Autowired
	@Qualifier("redisClient")
	private RedisTemplate<String, Object> redisTemplateClient;

	public GenericResponse createClient(Client client) {
		if (client != null) {
			String json = new JSONObject(client).toString();
			redisTemplateClient.opsForHash().put(RedisConstants.HASH_CLIENTS, client.getIdClient(), json);
			return new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL, APIConstants.CODE_SUCCESSFUL);
		}
		return new GenericResponse(APIConstants.MESSAGE_FAILED, APIConstants.CODE_FAILED);
	}

	public Client getClient(String idClient) throws JsonSyntaxException {
		if (idClient != null) {
			Gson gson = new Gson();
			String productJson = (String) redisTemplateClient.opsForHash().get(RedisConstants.HASH_CLIENTS, idClient);
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
			redisTemplateClient.opsForHash().delete(RedisConstants.HASH_CLIENTS, client.getIdClient());
			redisTemplateClient.opsForHash().put(RedisConstants.HASH_CLIENTS, client.getIdClient(), client);
		}
	}

}
