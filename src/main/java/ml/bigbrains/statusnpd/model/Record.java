package ml.bigbrains.statusnpd.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Record {
    private String type;
    private String documentIndex;
    private BigDecimal amount;
    private String operationDate;
    private String oktmo;
    private String kbk;
    private String status;
    private Integer taxPeriodId;
    private String dueDate;
    private String regionName;
    private String krsbAcceptedDate;

    private BigDecimal taxAmount;
    private BigDecimal bonusAmount;
    private BigDecimal paidAmount;
    private BigDecimal taxBaseAmount; //not in documentation
    private String chargeDate;
    private String taxOrganCode;
}
