package ml.bigbrains.statusnpd.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class IncomesResponse extends GenericResponse {
    private List<Content> content;
    private Boolean hasMore;
    private int currentLimit;
    private int currentOffset;
}
