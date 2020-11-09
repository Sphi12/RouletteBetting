package masivian.test.roulettebetting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import masivian.test.roulettebetting.model.AddRouletteResponse;
import masivian.test.roulettebetting.model.GenericResponse;
import masivian.test.roulettebetting.model.Roulette;
import masivian.test.roulettebetting.service.IRouletteService;

@RestController
@RequestMapping("roulettebetting/roulette")
@Validated
public class RouletteController {
	@Autowired
	private IRouletteService roulleteService;
	@Value("${masivian.code.failed:01}")
	private String codeFailed;
	@Value("${masivian.message.failed:null}")
	private String messageFailed;
	
	@PutMapping(path = "addRoulette", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addRoulette(@RequestParam MultiValueMap<String, String> requestParams) {
		AddRouletteResponse responseMessage = null;
		try {
			responseMessage = roulleteService.addRoulette();
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(new GenericResponse(messageFailed, codeFailed), HttpStatus.OK);
		}
	}
	
	@PutMapping(path = "rouletteOpening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> rouletteOpening(@PathVariable String id){
		GenericResponse response = roulleteService.rouletteOpening(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "getAllRoulettes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllRoulettes(@RequestParam MultiValueMap<String, String> requestParams){
		List<Roulette> response = roulleteService.getAllRoulettes();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
