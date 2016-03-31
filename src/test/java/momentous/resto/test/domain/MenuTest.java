package momentous.resto.test.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import momentous.resto.domain.Menu;

public class MenuTest {

	@Test
	public void getApplicableDays_emptyDays_noDaysReturned() {

		Menu menu = new Menu();

		Assert.assertEquals(0, menu.getApplicableDays().length);
	}

	@Test
	public void getApplicableDays_weekendDays_saturdayAndFridayReturned() {

		Menu menu = new Menu();
		menu.setApplicableDays(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
		ArrayList<DayOfWeek> days = Lists.newArrayList(menu.getApplicableDays());

		Assert.assertEquals(2, menu.getApplicableDays().length);
		Assert.assertTrue(days.contains(DayOfWeek.SATURDAY));
		Assert.assertTrue(days.contains(DayOfWeek.SUNDAY));
	}

}
