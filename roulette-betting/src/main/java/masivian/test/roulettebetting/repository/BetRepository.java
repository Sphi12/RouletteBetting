package masivian.test.roulettebetting.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.GenericResponse;

@Component
public class BetRepository {

	@Autowired
	@Qualifier("redisBet")
	private RedisTemplate<String, Object> redisTemplateBet;
	@Value("${masivian.code.failed:01}")
	private String codeFailed;
	@Value("${masivian.message.failed:null}")
	private String messageFailed;
	@Value("${masivian.message.successful:null}")
	private String messageSuccessful;
	@Value("${masivian.code.successful:null}")
	private String codeSuccessful;
	@Value("${masivian.redis.hash.bets:null}")
	private String hashBets;

	public GenericResponse createBet(Bet bet) {
		if (bet != null) {
			String json = new JSONObject(bet).toString();
			redisTemplateBet.opsForHash().put(hashBets, bet.getId(), json);
			return new GenericResponse(messageSuccessful, codeSuccessful);
		}
		return new GenericResponse(messageFailed, codeFailed);
	}

	public void deleteBet(Bet bet) {
		redisTemplateBet.opsForHash().delete(hashBets, bet.getId());
	}

	public List<Bet> getAllBets() {
		List<Bet> listBets = new ArrayList<>();
		Map<Object, Object> map = redisTemplateBet.opsForHash().entries(hashBets);
		if (!map.isEmpty()) {
			Gson gson = new Gson();
			map.forEach((k, v) -> {
				String BetJson = (String) v;
				Bet bet = gson.fromJson(BetJson, Bet.class);
				listBets.add(bet);
			});
		}

		return listBets;
	}
}
