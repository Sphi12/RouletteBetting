package masivian.test.roulettebetting.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.constants.RedisConstants;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.model.Roulette;

@Component
public class RouletteRedisRepository {

	@Autowired
	@Qualifier("redisRoullete")
	private RedisTemplate<String, Object> redisTemplateRoullete;

	public List<Roulette> getAllRoulettes() {
		List<Roulette> listRoulettes = new ArrayList<>();
		Map<Object, Object> map = redisTemplateRoullete.opsForHash().entries(RedisConstants.HASH_ROULETTES);
		if (!map.isEmpty()) {
			Gson gson = new Gson();
			map.forEach((k, v) -> {
				String rouletteJson = (String) v;
				Roulette roulette = gson.fromJson(rouletteJson, Roulette.class);
				listRoulettes.add(roulette);
			});
		}
		return listRoulettes;
	}

	public Roulette getRoulette(String idRoullete) throws JsonSyntaxException {
		try {
			if (idRoullete != null) {
				Gson gson = new GsonBuilder().setDateFormat(APIConstants.DATE_FORMAT).create();
				String productJson = (String) redisTemplateRoullete.opsForHash().get(RedisConstants.HASH_ROULETTES,
						idRoullete);
				if (productJson != null && !productJson.isEmpty()) {
					Roulette roulette = gson.fromJson(productJson, Roulette.class);
					if (roulette == null) {
						return roulette;
					} else {
						return roulette;
					}
				}
			}
		} catch (Exception exception) {

			System.out.println("catch " + exception.getMessage());
		}
		return null;
	}

	public void modifyRoulette(Roulette roulette) {
		if (roulette != null) {
			redisTemplateRoullete.opsForHash().delete(RedisConstants.HASH_ROULETTES, roulette.getIdRoulette());
			String json = new JSONObject(roulette).toString();
			redisTemplateRoullete.opsForHash().put(RedisConstants.HASH_ROULETTES, roulette.getIdRoulette(), json);
		}
	}

	public GenericResponse saveRoulette(Roulette roulette) {
		GenericResponse result = new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL, APIConstants.CODE_SUCCESSFUL);
		Map<String, String> rouletteMap = new HashMap<>();
		if (roulette != null) {
			String json = new JSONObject(roulette).toString();
			rouletteMap.put(roulette.getIdRoulette(), json);
			if (!rouletteMap.isEmpty()) {
				saveRoulette(rouletteMap);
			} else {
				result.setCodeResponsse(APIConstants.CODE_FAILED);
				result.setMessageResponse(APIConstants.MESSAGE_FAILED);
			}
		}

		return result;
	}

	public String loadListRoulettes(List<Roulette> rouletteList) {
		String result = APIConstants.CODE_FAILED;
		Map<String, String> roulettes = new HashMap<>();
		try {
			if (rouletteList != null && !rouletteList.isEmpty()) {
				rouletteList.stream().forEach(r -> {
					String json = new JSONObject(r).toString();
					roulettes.put(r.getIdRoulette(), json);
				});
				if (!roulettes.isEmpty()) {
					saveRoulettes(roulettes);
					result = APIConstants.CODE_SUCCESSFUL;
				} else {
					result = APIConstants.CODE_SUCCESSFUL;
				}
			}
		} catch (Exception exception) {
		}

		return result;
	}

	public void saveRoulette(Map<String, String> roulette) {
		if (roulette != null && !roulette.isEmpty()) {
			redisTemplateRoullete.opsForHash().putAll(RedisConstants.HASH_ROULETTES, roulette);
		}
	}

	public void saveRoulettes(Map<String, String> roulettes) {
		if (roulettes != null && !roulettes.isEmpty()) {
			redisTemplateRoullete.delete(RedisConstants.HASH_ROULETTES);
			redisTemplateRoullete.opsForHash().putAll(RedisConstants.HASH_ROULETTES, roulettes);
		}
	}

}
