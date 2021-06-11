package ml.bigbrains.statusnpd.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Content {
    private String approvedReceiptUuid;
    private String name;
    private List<Service> services;
    private String operationTime;
    private Integer taxPeriodId;
    private String partnerInn;
    private BigDecimal totalAmount;
    private Object cancellationInfo;
    private String clientInn;
    private String clientDisplayName;
    private String partnerName;
    private String inn;
}
