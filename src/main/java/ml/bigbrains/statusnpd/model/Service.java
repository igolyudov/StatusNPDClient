package ml.bigbrains.statusnpd.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Service {
    private String name;
    private Long quantity;
    private Integer serviceNumber;
    private BigDecimal amount;
}
