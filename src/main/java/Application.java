import hw55.dao.EmployeeDao;
import hw55.dao.impl.EmployeeDaoImpl;
import hw55.model.Employee;

public class Application {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.createOrUpdateEmployee(new Employee("Andrei", "Andreev","male",29,3));

        employeeDao.createOrUpdateEmployee(new Employee(14,"Dmitrii", "Lunev","male",31,1));

        System.out.println(employeeDao.getEmployeeById(3));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

        employeeDao.deleteEmployee(new Employee(5,"Alex", "Alexeev","male",21,2));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));
    }
}
