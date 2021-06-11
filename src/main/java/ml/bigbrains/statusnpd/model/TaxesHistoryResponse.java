package ml.bigbrains.statusnpd.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString(callSuper = true)
public class TaxesHistoryResponse extends GenericResponse{
    private String inn;
    private BigDecimal totalForPayment;
    private List<Record> records;
}
