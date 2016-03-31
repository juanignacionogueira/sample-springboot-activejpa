package momentous.resto.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import momentous.resto.api.dto.DtoGroup;
import momentous.resto.api.dto.MenuDto;
import momentous.resto.api.dto.translate.MenuDtoToEntityTranslator;
import momentous.resto.api.dto.translate.MenuEntityToDtoTranslator;
import momentous.resto.domain.Menu;

@RestController
@RequestMapping("/menu")
public class MenuController {

	private MenuEntityToDtoTranslator entityToDtoTranslator;
	private MenuDtoToEntityTranslator dtoToEntityTranslator;

	@Autowired
	public MenuController(MenuEntityToDtoTranslator entityToDtoTranslator,
			MenuDtoToEntityTranslator dtoToEntityTranslator) {
		super();
		this.entityToDtoTranslator = entityToDtoTranslator;
		this.dtoToEntityTranslator = dtoToEntityTranslator;
	}

	@ResponseBody
	@Transactional(readOnly = true)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<MenuDto> all() {
		List<Menu> all = Menu.all();
		return all.stream().map(menu -> entityToDtoTranslator.apply(menu)).collect(Collectors.toList());
	}

	@Transactional
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void save(@RequestBody MenuDto menuDto) {
		dtoToEntityTranslator.apply(menuDto).persist();
	}

	@ResponseBody
	@Transactional(readOnly = true)
	@RequestMapping(value = "/groupBy/{field}/{gap}/{count}", method = RequestMethod.GET)
	public DtoGroup<MenuDto> groupBy(@PathVariable String field, @PathVariable int gap, @PathVariable int count) {
		DtoGroup<MenuDto> group = new DtoGroup<MenuDto>(field, gap, count, this.all());
		return group;
	}

}
