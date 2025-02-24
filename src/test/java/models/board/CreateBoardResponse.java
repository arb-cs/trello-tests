package models.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBoardResponse {
    private String id;
    private String name;
    private String desc;
    private String message;
    private String error;
}
