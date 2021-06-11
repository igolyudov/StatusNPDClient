package ml.bigbrains.statusnpd;

import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.statusnpd.model.*;
import ml.bigbrains.statusnpd.model.enums.BuyerType;
import ml.bigbrains.statusnpd.model.enums.Order;
import ml.bigbrains.statusnpd.model.enums.ReceiptType;
import ml.bigbrains.statusnpd.model.enums.SortBy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;


@RunWith(JUnit4.class)
@Slf4j
public class ClientTest {

    private String testToken = System.getProperty("token");

    @Test
    public void testGetTaxPayerInfoWithError()
    {
        StatusNDPClient client = new StatusNDPClient();
        TaxPayerResponse info = client.getTaxPayer("wrongTokenValue", new TaxPayerRequest());
        log.debug("TaxPayner error '{}': '{}'",info.getCode(),info.getMessage());
    }

    @Test
    public void testGetTaxPayerInfo()
    {
        StatusNDPClient client = new StatusNDPClient();
        TaxPayerResponse info = client.getTaxPayer(testToken, new TaxPayerRequest());
        log.debug("TaxPayner info {}",info);
    }

    @Test
    public void testGetPaymentsInfo()
    {
        StatusNDPClient client = new StatusNDPClient();
        PaymentsResponse info = client.getPayments(testToken, new PaymentsRequest(true));
        log.debug("Payments info {}",info);
    }

    @Test
    public void testGetTaxesHistoryInfo()
    {
        StatusNDPClient client = new StatusNDPClient();
        TaxesHistoryResponse info = client.getTaxesHistory(testToken, new TaxesHistoryRequest());
        log.debug("Taxes history info {}",info);
    }

    @Test
    public void testGetIncomesInfo()
    {
        StatusNDPClient client = new StatusNDPClient();
        IncomesRequest req = new IncomesRequest(LocalDateTime.now().minusDays(5), LocalDateTime.now(), 0, 100, SortBy.total_amount, Order.desc, BuyerType.PERSON, ReceiptType.REGISTERED);
        IncomesResponse info = client.getIncomes(testToken, req);
        log.debug("incomes info {}",info);
    }
}
