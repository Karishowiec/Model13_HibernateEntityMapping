package com.spacetravel.service;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCrudService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getClient().getId() == null ||
                entityManager.find(Client.class, ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null client for ticket.");
        }

        if (ticket.getFromPlanet() == null || ticket.getFromPlanet().getId() == null ||
                entityManager.find(Planet.class, ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null fromPlanet for ticket.");
        }

        if (ticket.getToPlanet() == null || ticket.getToPlanet().getId() == null ||
                entityManager.find(Planet.class, ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null toPlanet for ticket.");
        }

        entityManager.persist(ticket);
    }

    public Ticket findById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    public List<Ticket> findAll() {
        return entityManager.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
    }

    @Transactional
    public void update(Long id, Ticket updatedTicket) {
        Ticket ticket = findById(id);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket with id " + id + " not found.");
        }

        if (updatedTicket.getClient() == null || updatedTicket.getClient().getId() == null ||
                entityManager.find(Client.class, updatedTicket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null client for ticket.");
        }

        if (updatedTicket.getFromPlanet() == null || updatedTicket.getFromPlanet().getId() == null ||
                entityManager.find(Planet.class, updatedTicket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null fromPlanet for ticket.");
        }

        if (updatedTicket.getToPlanet() == null || updatedTicket.getToPlanet().getId() == null ||
                entityManager.find(Planet.class, updatedTicket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null toPlanet for ticket.");
        }

        ticket.setClient(updatedTicket.getClient());
        ticket.setFromPlanet(updatedTicket.getFromPlanet());
        ticket.setToPlanet(updatedTicket.getToPlanet());
        ticket.setCreatedAt(updatedTicket.getCreatedAt());
        entityManager.merge(ticket);
    }

    @Transactional
    public void delete(Long id) {
        Ticket ticket = findById(id);
        if (ticket != null) {
            entityManager.remove(ticket);
        }
    }
}