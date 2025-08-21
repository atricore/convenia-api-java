package com.atricore.iam.convenia.api.mock;

import com.atricore.iam.convenia.api.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MockServer {

    private final Logger logger = LoggerFactory.getLogger(MockServer.class);

    private final List<Job> jobs = new CopyOnWriteArrayList<>();
    private final List<CostCenter> costCenters = new CopyOnWriteArrayList<>();
    private final List<Department> departments = new CopyOnWriteArrayList<>();
    private final List<Employee> employees = new CopyOnWriteArrayList<>();
    private final List<Ethnicity> ethnicities = new CopyOnWriteArrayList<>();
    private final List<Audit> employeeChanges = new CopyOnWriteArrayList<>();

    private final ObjectMapper mapper = new ObjectMapper();

    private String activeScenario = "";
    private int step = 0;

    private int port = 8006;
    private String scenarios = System.getProperty("user.dir") + "/src/test/resources/scenarios";

    /**
     * Usefull to test api clients
     */
    public static void main(String[] args) {
        MockServer s = new MockServer();

        String b = System.getenv("CONVENIA_API_MOCK_SCENARIOS_BASE");
        String a = System.getenv("CONVENIA_API_MOCK_SCENARIO_ACTIVE");
        String p = System.getenv("CONVENIA_API_MOCK_PORT");

        if (b != null) {
            s.setScenarios(b);
        }

        if (a != null) {
            s.setActiveScenario(a);
        }

        if (p != null) {
            s.setPort(Integer.parseInt(p));
        }

        s.run();
    }

    public String getActiveScenario() {
        return activeScenario;
    }

    public void setActiveScenario(String activeScenario) {
        this.activeScenario = activeScenario;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getScenarios() {
        return scenarios;
    }

    public void setScenarios(String scenarios) {
        this.scenarios = scenarios;
    }

    public void run() {
        logger.info("Starting MockServer : location " + System.getProperty("user.dir"));
        logger.info("Starting MockServer : port     " + port);

        if (activeScenario != null) {
            loadScenarioData();
        }

        Spark.port(port);

        // Schedule data updates
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateData();
            }
        }, 0, 5000); // Update every 5 seconds

        // Define endpoints
        Spark.get("/companies/departments", (req, res) -> wrapResponse(departments), new JsonTransformer());
        Spark.get("/companies/jobs", (req, res) -> wrapResponse(jobs), new JsonTransformer());
        Spark.get("/companies/cost-centers", (req, res) -> wrapResponse(costCenters), new JsonTransformer());
        Spark.get("/employees", (req, res) -> wrapResponse(employees), new JsonTransformer());
        Spark.get("/ethnicities", (req, res) -> wrapResponse(ethnicities), new JsonTransformer());
        Spark.get("/employees/:id", (req, res) -> wrapResponse(getEmployeeById(req.params(":id"))), new JsonTransformer());
        Spark.get("/employees/:id/changes", (req, res) -> wrapResponse(getEmployeeChangesById(req.params(":id"))), new JsonTransformer());
        Spark.get("/employees/:id/change/:change", (req, res) -> wrapResponse(getEmployeeChangeById(req.params(":id"), req.params(":change"))), new JsonTransformer());

        // Endpoint to change scenario
        Spark.post("/change-scenario/:scenario", (req, res) -> {
            String scenario = req.params(":scenario");
            activeScenario = scenario;
            step = 0; // Start from the first step
            loadScenarioData();
            return "Scenario changed to " + scenario;
        });

        // Endpoint to advance the scenario
        Spark.post("/advance-scenario", (req, res) -> {
            if (!activeScenario.isEmpty()) {
                step++;
                loadScenarioData();
                return "Advanced to step " + step + " of scenario " + activeScenario;
            } else {
                res.status(400);
                return "No active scenario to advance";
            }
        });
    }

    private <T> Response<List<T>> wrapResponse(List<T> data) {
        Response<List<T>> response = new Response<>();
        response.setData(data);
        return response;
    }

    private <T> Response<T> wrapResponse(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    private void loadScenarioData() {

        String baseDir = scenarios + "/" + activeScenario + "/step_" + step;
        logger.info("Loading scenario data: " + baseDir);

        updateListFromJsonFile(baseDir, "departments.json", departments, new TypeReference<List<Department>>() {});
        updateListFromJsonFile(baseDir, "jobs.json", jobs, new TypeReference<List<Job>>() {});
        updateListFromJsonFile(baseDir, "costcenters.json", costCenters, new TypeReference<List<CostCenter>>() {});
        updateListFromJsonFile(baseDir, "employees.json", employees, new TypeReference<List<Employee>>() {});
        updateEmployeeChanges(baseDir);

        logger.info(">>> Loaded employees  : " + employees.size());
        logger.info(">>> Loaded departments: " + departments.size());
        logger.info(">>> Loaded jobs       : " + jobs.size());
    }

    private <T> void updateListFromJsonFile(String baseDir, String fileName, List<T> list, TypeReference<List<T>> typeRef) {
        List<T> newList = readJsonFile(baseDir, fileName, typeRef);
        if (!newList.isEmpty()) {
            list.clear();
            list.addAll(newList);
        }

        logger.info("Loaded " + list.size() + " " + fileName);

    }

    private <T> List<T> readJsonFile(String baseDir, String fileName, TypeReference<List<T>> typeRef) {
        String filePath = baseDir + "/" + fileName;
        try {

            File file = new File(filePath);
            if (file.exists()) {
                return mapper.readValue(file, typeRef);
            } else {
                logger.info("File not found: " + filePath);
                return Collections.emptyList();
            }
        } catch (IOException e) {
            logger.error("Unable to read file " + filePath, e);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void updateEmployeeChanges(String baseDir) {
        for (Employee emp : employees) {
            String fileName = "employee-" + emp.getId() + "-changes.json";
            List<Audit> newChanges = readJsonFile(baseDir, fileName, new TypeReference<List<Audit>>() {});
            if (!newChanges.isEmpty()) {
                employeeChanges.removeIf(change -> change.getEmployeeId().equals(emp.getId()));
                employeeChanges.addAll(newChanges);
            }
        }
    }

    private Employee getEmployeeById(String id) {
        return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
    }

    private List<Audit> getEmployeeChangesById(String id) {
        return employeeChanges.stream().filter(change -> change.getEmployeeId().equals(id)).collect(Collectors.toList());
    }

    private Audit getEmployeeChangeById(String id, String changeId) {
        return employeeChanges.stream().filter(change -> change.getEmployeeId().equals(id) && change.getId().equals(changeId)).findFirst().orElse(null);
    }

    private void updateData() {
        // No default scenario logic. Scenarios are handled manually.
    }
}
