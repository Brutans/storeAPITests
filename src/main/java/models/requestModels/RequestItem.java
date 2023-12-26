package models.requestModels;
import models.additionalModels.Category;
import models.additionalModels.TagsItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestItem{
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private TagsItem[] tags;
    private String status;

}