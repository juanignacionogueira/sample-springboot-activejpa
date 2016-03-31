package momentous.resto.api.dto;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class MenuDto extends EntityDto {

	private static final long serialVersionUID = 8424806856004965503L;

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
	private DayOfWeek[] applicableDays;

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
		return applicableDays;
	}

	public void setApplicableDays(DayOfWeek[] applicableDays) {
		this.applicableDays = applicableDays;
	}

}
