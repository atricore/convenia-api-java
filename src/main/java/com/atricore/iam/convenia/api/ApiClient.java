package com.atricore.iam.convenia.api;

import com.atricore.iam.convenia.api.model.*;
import com.atricore.iam.convenia.api.model.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ApiClient {

    Response<List<Department>> getDepartments() throws ApiException;
    Response<List<Job>> getJobs() throws ApiException;
    Response<List<CostCenter>> getCostCenters() throws ApiException;

    Response<List<LeaveRequest>> getEmployeeHolidays(String id) throws ApiException;
    Response<List<LeaveRequest>> getEmployeeHolidaysByPage(String id, int page) throws ApiException;

    Response<List<Employee>> getEmployeesDismissals() throws ApiException;
    Response<List<Employee>> getEmployeesDismissalsByPage(int page) throws ApiException;

    /**
     * First page result of employees in convenia
     */
    Response<List<Employee>> getEmployees() throws ApiException;

    Response<List<Employee>> getEmployeesByEmail(String email) throws ApiException;

    /**
     * Get a page from the result
     */
    Response<List<Employee>> getEmployeesByPage(int page) throws ApiException;

    Response<Employee> getEmployee(String id) throws ApiException;

    Response<List<Audit>> getEmployeeChanges(String id) throws ApiException;

    Response<Audit> getEmployeeChange(String id, String change) throws ApiException;

    //-- Generic operations (to be hidden later)
    String sendGetRequest(String url) throws IOException, InterruptedException;

    CompletableFuture<String> sendGetRequestAsync(String url);

}
