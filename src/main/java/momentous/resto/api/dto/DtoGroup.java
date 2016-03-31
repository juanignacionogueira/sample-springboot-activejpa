package momentous.resto.api.dto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DtoGroup<Dto extends EntityDto> {

	private String groupField;
	private int gap;
	private int count;
	private HashMap<Integer, List<Dto>> groups;

	public DtoGroup(String groupField, int gap, int count, List<Dto> items) {
		this.groupField = groupField;
		this.gap = gap;
		this.count = count;
		this.groups = initGroups(gap, count);

		for (Dto dto : items) {
			Integer group = calculateGroup(dto);
			System.out.println(group);
			this.groups.get(group).add(dto);
		}
	}

	private HashMap<Integer, List<Dto>> initGroups(int gap, int count) {
		HashMap<Integer, List<Dto>> groups = Maps.newHashMap();

		for (int i = 0; i < count; i++) {
			groups.put(i * gap, Lists.newArrayList());
		}
		return groups;
	}

	private Integer calculateGroup(Dto dto) {
		try {
			Field field = dto.getClass().getDeclaredField(this.groupField);
			field.setAccessible(true);
			int groupKey = ((Number) field.get(dto)).intValue() / this.gap;
			return Integer.valueOf(groupKey >= count ? count - 1 : groupKey) * this.gap;
		} catch (Exception e) {
			throw new RuntimeException("Could not calculate item key", e);
		}
	}

	public String getGroupField() {
		return groupField;
	}

	public Number getGap() {
		return gap;
	}

	public int getCount() {
		return count;
	}

	public HashMap<Integer, List<Dto>> getGroups() {
		return groups;
	}

}
