package momentous.resto.api.dto.translate;

import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import momentous.resto.api.dto.MenuDto;
import momentous.resto.domain.Menu;

@Component
public class MenuDtoToEntityTranslator implements Function<MenuDto, Menu> {

	@Override
	public Menu apply(MenuDto dto) {

		Menu entity = null;
		
		if (dto.getId() == null || dto.getId() == 0) {
			entity = new Menu();
		} else {
			entity = Menu.findById(dto.getId());
		}
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setCurrencyCode(dto.getCurrencyCode());
		entity.setImagePath(dto.getImagePath());
		entity.setSinceDate(dto.getSinceDate());
		entity.setUntilDate(dto.getUntilDate());
		entity.setSinceTime(dto.getSinceTime());
		entity.setUntilTime(dto.getUntilTime());
		entity.setRanking(dto.getRanking());
		entity.setApplicableDays(dto.getApplicableDays());

		return entity;
	}

}
