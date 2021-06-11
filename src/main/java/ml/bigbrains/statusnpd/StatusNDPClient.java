package ml.bigbrains.statusnpd;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.statusnpd.model.*;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class StatusNDPClient {

    private String baseUrl = "https://statusnpd.nalog.ru/api/v1/public/";

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build();

    public StatusNDPClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public StatusNDPClient() {
    }

    private <T> T getRequest(String url, String token, Map<String, String> params, Class<T> responseClass) {

        HttpUrl.Builder requestUrl = HttpUrl.parse(baseUrl+url).newBuilder();

        for(Map.Entry<String, String> param : params.entrySet()) {
            requestUrl.addQueryParameter(param.getKey(),param.getValue());
        }

        okhttp3.Request request = new Request.Builder()
                .url(requestUrl.build())
                .header("Authorization","Bearer "+token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            if(response.body()!=null)
                return mapper.readValue(response.body().string(), responseClass);
            else
            {
                log.error("Empty response body after request to {}",url);
                return null;
            }
        }
        catch (IOException e)
        {
            log.error("Error in postRequest to {}",url,e);
            return null;
        }
    }

    public TaxPayerResponse getTaxPayer(String token, TaxPayerRequest request)
    {
        log.debug("taxpayer request");
        TaxPayerResponse response = getRequest(request.getRequestUrl(), token, request.getParamMap(), TaxPayerResponse.class);
        return response;
    }

    public PaymentsResponse getPayments(String token, PaymentsRequest request)
    {
        log.debug("payments request with params: {}",request.getParamMap());
        PaymentsResponse response = getRequest(request.getRequestUrl(), token, request.getParamMap(), PaymentsResponse.class);
        return response;
    }

    public TaxesHistoryResponse getTaxesHistory(String token, TaxesHistoryRequest request)
    {
        log.debug("taxes history request");
        TaxesHistoryResponse response = getRequest(request.getRequestUrl(), token, request.getParamMap(), TaxesHistoryResponse.class);
        return response;
    }

    public IncomesResponse getIncomes(String token, IncomesRequest request)
    {
        log.debug("incomes request with params {}",request.getParamMap());
        IncomesResponse response = getRequest(request.getRequestUrl(), token, request.getParamMap(), IncomesResponse.class);
        return response;
    }
}
