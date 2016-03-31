package momentous.resto.domain;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

/**
 * Un menú cuenta con un nombre, una descripción, un precio con su respectiva
 * moneda, una foto, los días que está disponible, fecha desde y hasta en el
 * cual es válido, horario desde hasta en el cual aplica y un ranking de
 * puntuación numérico que va desde el 1 al 5. Por ejemplo, el menú “cena 1” es
 * válido de Viernes a Domingos de 20:00 hs. a 23:00 hs, desde el 1 de Marzo al
 * 1 de Abril y tiene una puntuación de 5.
 * 
 * @author juan
 *
 */

@Entity
@Table(name = "MENU")
public class Menu extends AbstractEntity {

	private static final String TOKEN = ",";

	private String name;
	private String description;
	private BigDecimal price;
	private String currencyCode;
	private String imagePath;
	private LocalDate sinceDate;
	private LocalDate untilDate;
	private LocalTime sinceTime;
	private LocalTime untilTime;
	private int ranking;

	// Persist collection as String.
	private String applicableDaysString;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public LocalDate getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(LocalDate sinceDate) {
		this.sinceDate = sinceDate;
	}

	public LocalDate getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(LocalDate untilDate) {
		this.untilDate = untilDate;
	}

	public LocalTime getSinceTime() {
		return sinceTime;
	}

	public void setSinceTime(LocalTime sinceTime) {
		this.sinceTime = sinceTime;
	}

	public LocalTime getUntilTime() {
		return untilTime;
	}

	public void setUntilTime(LocalTime untilTime) {
		this.untilTime = untilTime;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public DayOfWeek[] getApplicableDays() {
		DayOfWeek[] daysOfWeek = new DayOfWeek[0];
		if (!StringUtils.isEmpty(applicableDaysString)) {
			daysOfWeek = Lists.newArrayList(StringUtils.split(applicableDaysString, TOKEN)).stream()
					.map(dayNumber -> DayOfWeek.of(Integer.valueOf(dayNumber).intValue())).toArray(DayOfWeek[]::new);
		}
		return daysOfWeek;
	}

	public void setApplicableDays(DayOfWeek... dayOfWeeks) {
		this.applicableDaysString = null;
		if (dayOfWeeks != null && dayOfWeeks.length > 0) {
			List<String> daysAsString = Lists.newArrayList(dayOfWeeks).stream()
					.map(day -> String.valueOf(day.getValue())).collect(Collectors.toList());
			this.applicableDaysString = StringUtils.collectionToDelimitedString(daysAsString, TOKEN);
		}
	}
	
}
