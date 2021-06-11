package ml.bigbrains.statusnpd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class TaxesHistoryRequest {

    private String requestUrl = "taxes/history";

    private Map<String,String> paramMap = new HashMap<>();
}
