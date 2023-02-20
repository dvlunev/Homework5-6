package hw56.dao.impl;

import hw56.dao.CityDao;
import hw56.dao.EmployeeDao;
import hw56.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hw56.config.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public void createOrUpdateEmployee(Employee employee) {
        if (employee.getCity() != null && cityDao.findById(employee.getCity().getCityId()).isEmpty()) {
            employee.setCity(null);
        }
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Employee.class, id));
        }
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees.addAll(session.createQuery("FROM Employee", Employee.class).list());
            transaction.commit();
        }
        return employees;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
