package masivian.test.roulettebetting.repository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.constants.RedisConstants;
import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;

@Component
public class BetRepository {

	@Autowired
	@Qualifier("redisBet")
	private RedisTemplate<String, Object> redisTemplateBet;

	public GenericResponse createBet(Bet bet) {
		if (bet != null) {
			String json = new JSONObject(bet).toString();
			redisTemplateBet.opsForHash().put(RedisConstants.HASH_BETS, bet.getId(), json);
			return new GenericResponse(APIConstants.MESSAGE_SUCCESSFUL_BET, APIConstants.CODE_SUCCESSFUL);
		}
		return new GenericResponse(APIConstants.MESSAGE_FAILED, APIConstants.CODE_FAILED);
	}

}
