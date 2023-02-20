package hw56.dao.impl;

import hw56.config.HibernateSessionFactoryUtil;
import hw56.dao.CityDao;
import hw56.model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {

    @Override
    public void createOrUpdateCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(city);
            transaction.commit();
        }
    }

    @Override
    public Optional<City> getCityById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }

    @Override
    public List<City> getAllCityList() {
        List<City> cities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            cities.addAll(session.createQuery("FROM City", City.class).list());
            transaction.commit();
        }
        return cities;
    }

    @Override
    public void deleteCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }

    @Override
    public Optional<City> findById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }
}
