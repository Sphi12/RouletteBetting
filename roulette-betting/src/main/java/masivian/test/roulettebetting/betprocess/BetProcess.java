package masivian.test.roulettebetting.betprocess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import masivian.test.roulettebetting.command.CommandBet;
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
	@Value("${masivian.roulette.open.state:null}")
	private String openState;
	@Value("${masivian.roulette.closed.state:null}")
	private String closedRoulette;
	@Value("${masivian.code.failed:01}")
	private String codeFailed;
	@Value("${masivian.message.failed:null}")
	private String messageFailed;
	@Value("${masivian.bet.lost:null}")
	private String lostBet;
	@Value("${masivian.bet.won:null}")
	private String wonBet;
	@Value("${masivian.code.successful:01}")
	private String codeSuccessful;
	@Value("${masivian.bet.color.black:null}")
	private String black;
	@Value("${masivian.bet.color.red:null}")
	private String red;

	public GenericResponse generateBet(CommandBet commandBet, String userId) {
		GenericResponse response;
		if (commandBet != null) {
			Roulette roulette = rouletteservice.findRouletteById(commandBet.getIdRoulette());
			Client client = clientService.getClient(userId);
			if (roulette != null && roulette.getRouletteStatus().equals(openState) && client != null
					&& client.getTotalAmount() >= commandBet.getAmount()) {
				response = betService.createBet(new Bet(util.generateId(6), commandBet.getNumber(),
						commandBet.getColour(), roulette, commandBet.getAmount(), client, null));
				return response;
			}
		}
		return new GenericResponse(messageFailed, codeFailed);
	}

	public List<Bet> closedBet(String idRoulette) {

		List<Bet> listBets = null;
		if (idRoulette != null) {
			GenericResponse result = rouletteservice.closedRoulette(idRoulette);
			if (result.getCodeResponsse().equals(codeSuccessful)) {
				listBets = getWinners(idRoulette, betService.getBets());
				listBets.stream().forEach(b ->{
					clientService.modifyClient(b.getClient());
				});
			}
		}
		deleteBetsRoulettes(listBets);
		return listBets;
	}

	public void deleteBetsRoulettes(List<Bet> listBets) {
		if(!listBets.isEmpty()) {
			listBets.stream().forEach(b -> {
				betService.deleteBet(b);
			});
		}
	}
	
	public List<Bet> getWinners(String idRoullete, List<Bet> listBets) {
		List<Bet> list = new ArrayList<>();
		if (!listBets.isEmpty()) {
			String[] winningNumber = generateWinningNumber();
			listBets.stream().forEach(b -> {
				boolean win = false;
				if (b.getRoulette().getIdRoulette().equals(idRoullete)) {
					if ((b.getNumber() == Integer.parseInt(winningNumber[0]))) {
						b.getClient().setTotalAmount(b.getClient().getTotalAmount() * 5);
						win = true;
					}
					if (b.getColour() != null && b.getColour().equals(winningNumber[1])) {
						b.getClient().setTotalAmount(b.getClient().getTotalAmount() * 1.8);
						win = true;
					}
					if (win) {
						b.setResult(wonBet);
					} else {
						b.setResult(lostBet);
						b.getClient().setTotalAmount(b.getClient().getTotalAmount() - b.getBetAmount());
					}
				}
				list.add(b);
			});
		}

		return list;
	}

	public String[] generateWinningNumber() {
		String[] result = new String[2];
		int number = (int) (Math.random() * 36);
		result[0] = String.valueOf(number);
		if (number % 2 == 0) {
			result[1] = red;
		} else {
			result[1] = black;
		}

		return result;
	}
}
