import hw56.dao.CityDao;
import hw56.dao.EmployeeDao;
import hw56.dao.impl.CityDaoImpl;
import hw56.dao.impl.EmployeeDaoImpl;
import hw56.model.City;
import hw56.model.Employee;

public class Application {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        City city1 = new City(1,"Saint-Petersburg");
        City city3 = new City(3,"Sevastopol");

//        employeeDao.createOrUpdateEmployee(new Employee("Andrei", "Andreev","male",29, city3));

        employeeDao.createOrUpdateEmployee(new Employee(23,"Dmitrii", "Lunev","male",32, city1));

        System.out.println(employeeDao.getEmployeeById(3));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

//        employeeDao.deleteEmployee(new Employee(20,"Andrei", "Andreev","male",29, city3));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

        CityDao cityDao = new CityDaoImpl();

//        cityDao.createOrUpdateCity(new City("Tver"));

        cityDao.createOrUpdateCity(new City(3, "Sevastopol"));

//        System.out.println(cityDao.getCityById(3));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

//        cityDao.getAllCityList().forEach(city -> System.out.println(city));

        cityDao.deleteCity(city3);

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

//        cityDao.getAllCityList().forEach(city -> System.out.println(city));
    }
}
