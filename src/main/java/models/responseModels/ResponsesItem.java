package models.responseModels;

import models.additionalModels.Category;
import models.additionalModels.TagsItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsesItem {
	private String[] photoUrls;
	private String name;
	private long id;
	private Category category;
	private TagsItem[] tags;
	private String status;
}