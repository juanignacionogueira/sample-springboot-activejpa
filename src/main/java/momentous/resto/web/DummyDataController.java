package momentous.resto.web;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import momentous.resto.domain.Menu;

@RestController
@RequestMapping("/dummy")
public class DummyDataController {

	@ResponseBody
	@Transactional(readOnly = true)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String dummy() {
		return "Greetings from Spring Boot!";
	}

	@Transactional(readOnly = false)
	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public void generate() {
		for (int i = 0; i < 10; i++) {
			Menu menu = new Menu();
			menu.setName("Name" + i);
			menu.setDescription("Name" + i);
			menu.setPrice(BigDecimal.valueOf(i));
			menu.setCurrencyCode("USD");
			menu.setImagePath("/images/file" + i + ".png");
			menu.setSinceDate(LocalDate.now());
			menu.setUntilDate(LocalDate.now());
			menu.setSinceTime(LocalTime.now());
			menu.setUntilTime(LocalTime.now());
			menu.setRanking((((int) (Math.random() * 100)) % 5) + 1);
			menu.setApplicableDays(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
			menu.persist();
		}
	}

}
