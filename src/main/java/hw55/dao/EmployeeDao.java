package hw55.dao;

import hw55.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void createOrUpdateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployeeList();
    void deleteEmployee(Employee employee);
}
