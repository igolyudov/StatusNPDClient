package ml.bigbrains.statusnpd.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TaxPayerRequest {
    private String requestUrl = "taxpayer";

    private Map<String,String> paramMap = new HashMap<>();
}
