package com.atricore.iam.convenia.api.test;


import com.atricore.iam.convenia.api.ApiException;
import com.atricore.iam.convenia.api.model.*;
import com.atricore.iam.convenia.api.ApiClientImpl;
import com.atricore.iam.convenia.api.ApiClient;
import com.atricore.iam.convenia.api.mock.MockServer;
import org.apiguardian.api.API;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ApiIntegrationTest {

    static final String CONVENIA_API_LIVE_SVC = "CONVENIA_API_LIVE_SVC";
    static final String CONVENIA_API_TOKEN = "CONVENIA_API_TOKEN";

    private static final Logger logger = LoggerFactory.getLogger(ApiIntegrationTest.class);

    private String token = "";
    private static ApiClient apiClient;
    private static MockServer server;

    @BeforeAll
    static void setUp() {
        // Configure client
        String token = System.getenv(CONVENIA_API_TOKEN);
        String baseUrl = null;

        if ((System.getenv(CONVENIA_API_LIVE_SVC) == null || !Boolean.parseBoolean(System.getenv(CONVENIA_API_LIVE_SVC)))) {

            int port = 8006;
            baseUrl = "http://localhost:" + port + "/";
            token = "changeme";

            // Start server
            logger.info(">>> STARTING MOCK SERVER");
            server = new MockServer();
            server.setPort(port);
            server.setScenarios("./src/test/resources/scenarios");
            server.setActiveScenario("sc1");
            server.run();
        }


        logger.info("Using base url: {}", baseUrl);
        assert(token != null && !token.isEmpty());
        apiClient = new ApiClientImpl(token, baseUrl);
    }

    @Test
    void apiDepartments() throws Exception{
        Response<List<Department>>  r = apiClient.getDepartments();
        r.getData().forEach(d -> {
            logger.info("department: {} {}", d.getName(), d.getId());
        });
    }

    @Test
    void apiJobs() throws Exception{
        Response<List<Job>>  r = apiClient.getJobs();
        r.getData().forEach(j -> {
            logger.info("job: {}", j.getName());
        });
    }

    @Test
    void apiCostCenters() throws Exception{
        Response<List<CostCenter>>  r = apiClient.getCostCenters();
        r.getData().forEach(c -> {
            logger.info("cost-center: {}", c.getName());
        });
    }

    @Test
    void apiEmployees() throws Exception {
        Response<List<Employee>>  r = apiClient.getEmployees();
        r.getData().forEach(e -> {
            // Status only available in the employee LIST API
            logger.info("------------------------------------------------------------------------");
            logger.info("employee ls: {}[{}] {} {} {}", e.getName(), e.getId(), e.getStatus(), e.getHiringDate(), e.getCustomFields() != null ? e.getCustomFields().size() : -1);
            try {
                Response<Employee> re = apiClient.getEmployee(e.getId());
                Employee ne = re.getData();

                // Custom Fields only available in the employee by id API
                logger.info("employee id: {}[{}] {} {} {}", ne.getName(), ne.getId(), ne.getStatus(), ne.getHiringDate(), ne.getCustomFields() != null ? ne.getCustomFields().size() : -1);
                //logger.info("custom fields: {}", ne.getCustomFields());
                logger.info("employee hd: {} {}", e.getHiringDate(), ne.getHiringDate());

                if (ne.getCustomFields() != null)
                    ne.getCustomFields().forEach(f -> logger.info("employee cf: {}={}" , f.getName(), f.getValue()));
            } catch (ApiException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Test
    void apiEmployee() throws Exception{

        String oid = "20dea1b0-0fb1-408d-a193-ca3d2599abc3";
        Response<Employee>  r = apiClient.getEmployee(oid);
        logger.info("employee: {}", r.getData().getName());
        logger.info("custom fields: {}", r.getData().getCustomFields());

        if (r.getData().getCustomFields() != null) {
            r.getData().getCustomFields().forEach(cf -> {
                logger.info("cf: {} {}", cf.getName(), cf.getValue());
            });
        }
    }

    void apiEmployeeChanges() throws Exception{
        Response<List<Audit>>  r = apiClient.getEmployeeChanges("ea17b28f-8c2c-4d41-a41d-33b135067997");
        r.getData().forEach(e -> {
            logger.info("change: {} {}", e.getAction(), e.getId());
            e.getChanges().forEach((k,v) -> {
                logger.info("change: {}:{}", k, v.getNewValue());
            });
        });
    }

    void apiEmployeeChange() throws Exception{
        Response<Audit>  r = apiClient.getEmployeeChange("ea17b28f-8c2c-4d41-a41d-33b135067997", "3aa78db6-9c05-4c13-89c1-028a3ea796e6");
        Audit e = r.getData();

        logger.info("change: {}", e.getAction());
        e.getChanges().forEach((k,v) -> {
            logger.info("change: {}:{}", k, v.getNewValue());
        });

    }


    void testCompaniesDepartments() throws Exception{
        System.out.println(apiClient.sendGetRequest("companies/departments"));
    }

    void testEmployees() throws Exception{
        System.out.println(apiClient.sendGetRequest("employees/ea17b28f-8c2c-4d41-a41d-33b135067997/change-histories"));
    }
}
