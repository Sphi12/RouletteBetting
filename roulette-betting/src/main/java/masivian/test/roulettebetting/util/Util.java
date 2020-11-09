package masivian.test.roulettebetting.util;

import org.springframework.stereotype.Component;

@Component
public class Util {

	public String generateId(final int tamanio) {
		int number1 = 48;
		int number2 = 122;
		StringBuilder random = new StringBuilder();
		for (int i = 1; i <= tamanio; i++) {
			if (i == tamanio) {
				number2 = 57;
			}
			int rendomNumber = (int) Math.floor(Math.random() * (number2 - number1) + number1);
			if ((rendomNumber > 57 && rendomNumber < 65) || (rendomNumber > 90 && rendomNumber < 97)) {
				rendomNumber += 7;
			}
			random.append((char) rendomNumber);
		}
		return random.toString();
	}
}
