package ml.bigbrains.statusnpd.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class PaymentsResponse extends GenericResponse {
    private String inn;
    private List<Record> records;
}
