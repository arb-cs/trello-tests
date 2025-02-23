package models.lists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponse {
    private String id;
    private String name;
    private boolean closed;
}
