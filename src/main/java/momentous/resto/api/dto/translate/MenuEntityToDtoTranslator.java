package momentous.resto.api.dto.translate;

import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import momentous.resto.api.dto.MenuDto;
import momentous.resto.domain.Menu;

@Component
public class MenuEntityToDtoTranslator implements Function<Menu, MenuDto> {

	@Override
	public MenuDto apply(Menu entity) {

		MenuDto dto = new MenuDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getPrice());
		dto.setCurrencyCode(entity.getCurrencyCode());
		dto.setImagePath(entity.getImagePath());
		dto.setSinceDate(entity.getSinceDate());
		dto.setUntilDate(entity.getUntilDate());
		dto.setSinceTime(entity.getSinceTime());
		dto.setUntilTime(entity.getUntilTime());
		dto.setRanking(entity.getRanking());
		dto.setApplicableDays(entity.getApplicableDays());

		return dto;
	}

}
