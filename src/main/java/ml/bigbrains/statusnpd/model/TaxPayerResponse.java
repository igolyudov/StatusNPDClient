package ml.bigbrains.statusnpd.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TaxPayerResponse extends GenericResponse {
    private String displayName;
    private String inn;
    private String sex;
    private String registrationOktmoCode;
    private String registrationOktmoName;
    private String snils;
}
