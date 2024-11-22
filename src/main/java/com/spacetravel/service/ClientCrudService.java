package com.spacetravel.service;

import com.spacetravel.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientCrudService {
    private final SessionFactory sessionFactory;

    public ClientCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        }
    }

    public Client read(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(client);
            session.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) session.remove(client);
            session.getTransaction().commit();
        }
    }
}

