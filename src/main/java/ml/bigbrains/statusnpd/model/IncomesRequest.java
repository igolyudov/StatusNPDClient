package ml.bigbrains.statusnpd.model;

import lombok.Data;
import ml.bigbrains.statusnpd.model.enums.BuyerType;
import ml.bigbrains.statusnpd.model.enums.Order;
import ml.bigbrains.statusnpd.model.enums.ReceiptType;
import ml.bigbrains.statusnpd.model.enums.SortBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
public class IncomesRequest {
    private String requestUrl = "incomes";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private LocalDateTime from;
    private LocalDateTime to;
    private int offset = 0;
    private int limit = 100;
    private SortBy sortBy;
    private Order order;
    private BuyerType buyerType;
    private ReceiptType receiptType;

    public IncomesRequest(LocalDateTime from, LocalDateTime to, int offset, int limit, SortBy sortBy, Order order, BuyerType buyerType, ReceiptType receiptType) {
        this.from = from;
        this.to = to;
        this.offset = offset;
        this.limit = limit;
        this.sortBy = sortBy;
        this.order = order;
        this.buyerType = buyerType;
        this.receiptType = receiptType;
    }

    public Map<String,String> getParamMap()
    {
        Map<String,String> params = new HashMap<>();
        params.put("offset",Integer.toString(offset));
        params.put("limit",Integer.toString(limit));
        if(sortBy!=null && order!=null)
            params.put("sortBy",sortBy.name()+":"+order.name());
        if(buyerType!=null)
            params.put("buyerType",buyerType.name());
        if(receiptType!=null)
            params.put("receiptType",receiptType.name());
        if(from!=null)
            params.put("from",from.format(formatter));
        if(to!=null)
            params.put("to",to.format(formatter));
        return params;
    }
}
