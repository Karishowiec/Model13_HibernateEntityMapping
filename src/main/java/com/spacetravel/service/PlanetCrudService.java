package com.spacetravel.service;

import com.spacetravel.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PlanetCrudService {
    private final SessionFactory sessionFactory;

    public PlanetCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(planet);
            session.getTransaction().commit();
        }
    }

    public Planet read(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(planet);
            session.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) session.remove(planet);
            session.getTransaction().commit();
        }
    }
}

