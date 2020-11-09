package masivian.test.roulettebetting.betprocess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import masivian.test.roulettebetting.command.CommandBet;
import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.model.Bet;
import masivian.test.roulettebetting.model.Client;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.model.Roulette;
import masivian.test.roulettebetting.service.IBetService;
import masivian.test.roulettebetting.service.IClientService;
import masivian.test.roulettebetting.service.IRouletteService;
import masivian.test.roulettebetting.util.Util;

@Component
public class BetProcess {

	@Autowired
	private IRouletteService rouletteservice;
	@Autowired
	private IBetService betService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private Util util;

	public GenericResponse generateBet(CommandBet commandBet, String userId) {
		GenericResponse response;
		if (commandBet != null) {
			Roulette roulette = rouletteservice.findRouletteById(commandBet.getIdRoulette());
			Client client = clientService.getClient(userId);
			if (roulette != null && roulette.getRouletteStatus().equals(APIConstants.OPEN_STATE) && client != null
					&& client.getTotalAmount() >= commandBet.getAmount()) {
				response = betService.createBet(new Bet(util.generateId(6), commandBet.getNumber(),
						commandBet.getColour(), roulette, commandBet.getAmount(), client));
				return response;
			}
		}
		return new GenericResponse(APIConstants.MESSAGE_FAILED, APIConstants.CODE_FAILED);
	}

}
