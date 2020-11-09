package masivian.test.roulettebetting.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masivian.test.roulettebetting.betprocess.BetProcess;
import masivian.test.roulettebetting.command.CommandBet;
import masivian.test.roulettebetting.constants.APIConstants;
import masivian.test.roulettebetting.model.GenericResponse;

@RestController
@RequestMapping("roulettebetting/bet")
@Validated
public class BetController {

	@Autowired
	BetProcess betProcess;

	@PutMapping(path = "addBet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addBet(@RequestHeader Map<String, String> header,
			@Valid @RequestBody CommandBet body) {
		GenericResponse responseMessage = null;
		try {
			responseMessage = betProcess.generateBet(body, header.get("userid"));
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(APIConstants.CODE_FAILED, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
