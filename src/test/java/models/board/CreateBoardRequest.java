package models.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBoardRequest {
    private String name;
    private String desc;
    private boolean defaultLists;
}
