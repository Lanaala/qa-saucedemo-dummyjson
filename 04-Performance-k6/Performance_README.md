# Performance Testing

This folder contains all performance testing artifacts created to evaluate the
responsiveness, stability, and reliability of selected DummyJSON API endpoints
under concurrent load conditions.

Performance testing was conducted at the API level only using k6, with the goal
of validating response times, throughput, and error rates under expected load.

---

## Performance Testing Objectives

The main objectives of performance testing were to:

- Validate API responsiveness under concurrent usage
- Measure response times and throughput
- Ensure error rates remain within acceptable limits
- Identify potential performance bottlenecks related to payload size
- Verify system stability during sustained load

---

## Tools and Technologies

- k6 for load generation and performance metrics collection
- JavaScript-based k6 test scripts
- DummyJSON public API as the test target

---

## Tested API Endpoints

The following DummyJSON API endpoints were included in the performance testing scope:

- `GET /products`  
  Retrieves a list of all products. This endpoint returns a relatively large
  payload and represents a higher performance risk.

- `GET /products/{id}`  
  Retrieves detailed information for a single product by ID.

- `GET /products/search?q=phone`  
  Searches products using a query parameter.

---

## Performance Test Types

### Smoke Test

The smoke test was executed to validate basic API availability and responsiveness
before running heavier load scenarios.

- Virtual Users (VUs): 2  
- Duration: 30 seconds  

This test confirmed that all tested endpoints were reachable and responding
correctly.

---

### Load Test

The load test evaluated system behavior under expected concurrent usage.

- Ramp-up to 50 Virtual Users
- Duration: 3 minutes
- Gradual ramp-up and ramp-down load pattern

This approach simulated realistic traffic growth and sustained load conditions.

---

## Load Profile and Thresholds

The following performance thresholds were applied during testing:

- `http_req_duration`: p95 < 300 ms  
- `http_req_failed`: error rate < 1%

All defined thresholds were met successfully during execution.

---

## Key Performance Indicators (KPIs)

The following KPIs were measured during the load test:

- Average Response Time: 61.09 ms
- Median (p50): 13.44 ms
- p90 Response Time: 150.86 ms
- p95 Response Time: 156.19 ms
- Maximum Response Time: 438.75 ms
- Throughput: approximately 27 requests per second
- Error Rate: 0.00%
- Total Requests: 4,950

The p95 metric represents near worst-case response times experienced by users.

---

## Results Analysis

Performance testing results indicate stable and consistent API behavior under
concurrent load.

Key observations include:

- No failed requests were recorded during testing
- Response times remained well below the defined threshold limits
- Slightly higher response times were observed for endpoints returning larger
  payloads, particularly `GET /products`
- Throughput remained stable throughout the test duration

The observed response time increase at higher percentiles is primarily attributed
to payload size and data serialization overhead.

---

## Performance Improvement Recommendations

Based on test observations, the following improvements are recommended:

1. Implement pagination for product listing endpoints to reduce payload size
2. Apply server-side caching for frequently accessed product data
3. Enable response compression to reduce network transfer time

---

## Folder Structure

