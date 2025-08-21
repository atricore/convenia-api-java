package com.atricore.iam.convenia.api;

import com.atricore.iam.convenia.api.model.*;
import com.atricore.iam.convenia.api.model.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClientImpl implements ApiClient {

    public static final int MAX_ATTEMPTS = 10;

    private static final Logger logger = LoggerFactory.getLogger(ApiClientImpl.class);

    private final HttpClient httpClient;
    private String baseUrl = "https://public-api.convenia.com.br/api/v3/";
    private String token;
    private ObjectMapper mapper;

    public ApiClientImpl(String token, String baseUrl) {
        this(token);
        if (baseUrl != null && !baseUrl.isEmpty())
            this.baseUrl = baseUrl;

        if (!this.baseUrl.endsWith("/"))
            this.baseUrl = this.baseUrl + "/";

        logger.info("using API URL: " + this.baseUrl);
    }

    public ApiClientImpl(String token) {
        this.token = token;
        this.mapper = new ObjectMapper();
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    @Override
    public Response<List<Department>> getDepartments() throws ApiException {
        try {
            String r = sendGetRequest("companies/departments");
            Response<List<Department>> response = mapper.readValue(r, new TypeReference<Response<List<Department>>>() {});
            logger.debug("departments: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Job>> getJobs() throws ApiException {
        try {
            String r = sendGetRequest("companies/jobs");
            Response<List<Job>> response = mapper.readValue(r, new TypeReference<Response<List<Job>>>() {});
            logger.debug("jobs: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    public Response<List<CostCenter>> getCostCenters() throws ApiException {
        try {
            String r = sendGetRequest("companies/cost-centers");
            Response<List<CostCenter>> response = mapper.readValue(r, new TypeReference<Response<List<CostCenter>>>() {});
            logger.debug("cost-centers: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Employee>> getEmployeesDismissals() throws ApiException {
        try {
            String r = sendGetRequest("employees/dismissed");
            logger.debug("employees: {}", r);
            Response<List<Employee>> response = mapper.readValue(r, new TypeReference<Response<List<Employee>>>() {});
            logger.debug("employees: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Employee>> getEmployeesDismissalsByPage(int page) throws ApiException {
        try {
            String r = sendGetRequest("employees/dismissed?page=" + page);
            logger.debug("employees: page #{} {}", page, r);
            Response<List<Employee>> response = mapper.readValue(r, new TypeReference<Response<List<Employee>>>() {});
            logger.debug("employees: page #{} {}", page, response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<LeaveRequest>> getEmployeeHolidays(String id) throws ApiException {
        try {
            if (id.isEmpty()) {
                throw new ApiException("employee id cannot be empty");
            }
            String r = sendGetRequest("employees/" + id + "/vacations/solicitations");
            logger.debug("employees/vacations: {}", r);
            Response<List<LeaveRequest>> response = mapper.readValue(r, new TypeReference<Response<List<LeaveRequest>>>() {});
            logger.debug("employees/vacations: {}",
                    response != null && response.getData() != null ? response.getData().size() : "N/A");
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<LeaveRequest>> getEmployeeHolidaysByPage(String id, int page) throws ApiException {
        try {
            if (id.isEmpty()) {
                throw new ApiException("employee id cannot be empty");
            }
            String r = sendGetRequest("employees/" + id + "/vacations/solicitations?page=" + page);
            logger.debug("employees/vacations: page#{} {}", page, r);
            Response<List<LeaveRequest>> response = mapper.readValue(r, new TypeReference<Response<List<LeaveRequest>>>() {});
            logger.debug("employees/vacations: page#{} {}",
                    page,
                    response != null && response.getData() != null ? response.getData().size() : "N/A");
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    public Response<List<Employee>> getEmployees() throws ApiException {
        try {
            String r = sendGetRequest("employees");
            logger.debug("employees: {}", r);
            Response<List<Employee>> response = mapper.readValue(r, new TypeReference<Response<List<Employee>>>() {});
            logger.debug("employees: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Employee>> getEmployeesByEmail(String email) throws ApiException {
        try {
            String r = sendGetRequest("employees?match[email]=" + email);
            logger.debug("employees: {}", r);
            Response<List<Employee>> response = mapper.readValue(r, new TypeReference<Response<List<Employee>>>() {});
            logger.debug("employees: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Employee>> getEmployeesByPage(int page) throws ApiException {
        try {
            String r = sendGetRequest("employees?page=" + page);
            logger.debug("employees: page #{} {}", page, r);
            Response<List<Employee>> response = mapper.readValue(r, new TypeReference<Response<List<Employee>>>() {});
            logger.debug("employees: page #{} {}", page, response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    public Response<Employee> getEmployee(String id) throws ApiException {
        try {
            if (id.isEmpty()) {
                throw new ApiException("employee id cannot be empty");
            }
            String r = sendGetRequest("employees/"+id);
            logger.debug("employee: {}", r);
            Response<Employee> response = mapper.readValue(r, new TypeReference<Response<Employee>>() {});
            logger.debug("employee: {}", 
              response != null && response.getData() != null ? response.getData().getLastName() : "N/A");
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<List<Audit>> getEmployeeChanges(String id) throws ApiException {
        try {
            if (id.isEmpty()) {
                throw new ApiException("employee id cannot be empty");
            }
            String r = sendGetRequest("employees/"+id+"/change-histories");
            Response<List<Audit>> response = mapper.readValue(r, new TypeReference<Response<List<Audit>>>() {});
            logger.debug("change: {}", response.getData().size());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    @Override
    public Response<Audit> getEmployeeChange(String id, String change) throws ApiException {
        try {
            if (id.isEmpty()) {
                throw new ApiException("employee id cannot be empty");
            }
            if (change.isEmpty()) {
                throw new ApiException("change id cannot be empty");
            }
            String r = sendGetRequest("employees/"+id+"/change-histories/" + change);
            Response<Audit> response = mapper.readValue(r, new TypeReference<Response<Audit>>() {});
            logger.debug("change: {}", response.getData().getAction());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(e);
        }
    }

    public String sendGetRequest(String url) throws IOException, InterruptedException {

        // Handle http 429

        URI uri = URI.create(baseUrl + url);
        logger.debug(">>>>>> Request: " + uri.toASCIIString());

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .header("token",  token)
                .build();

        boolean processed = false;
        int attempt = 0;

        HttpResponse<String> response = null;
        while (!processed && attempt < MAX_ATTEMPTS) {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 429) {
                attempt ++;
                HttpHeaders h = response.headers();
                Optional<String> ra = h.firstValue("Retry-After");
                logger.debug(">>>>> Received HTTP/429 - Retry-After:" + ra.orElse("NO HEADER !!"));
                long tout = ra.map(Long::parseLong).orElse(40L) * 1000L;
                logger.debug(">>>>> Waiting HTTP/429 for " + tout + "ms");
                Thread.sleep(tout);
            } else {
                processed = true;
            }
        }
        if (!processed) {
            logger.error("Unable to resolve HTTP/429");
        }
        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch data: " + response.statusCode());
        }
        return response.body();

    }

    public CompletableFuture<String> sendGetRequestAsync(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    System.err.println("Request failed: " + e.getMessage());
                    return null;
                });
    }

}
