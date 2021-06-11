package ml.bigbrains.statusnpd.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PaymentsRequest {
    private String requestUrl="payments";
    private boolean onlyPaid;

    public PaymentsRequest(boolean onlyPaid) {
        this.onlyPaid = onlyPaid;
    }

    public Map<String,String> getParamMap()
    {
        Map<String,String> paramMap = new HashMap<>();
        if(onlyPaid)
            paramMap.put("onlyPaid","true");
        else
            paramMap.put("onlyPaid","false");
        return paramMap;
    }
}
