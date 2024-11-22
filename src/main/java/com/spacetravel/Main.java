package com.spacetravel;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.service.ClientCrudService;
import com.spacetravel.service.PlanetCrudService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);


        Client client = new Client();
        client.setName("John Doe");
        clientService.create(client);
        System.out.println("Client created: " + client.getName());

        // **Створення Planet**
        Planet planetFrom = new Planet();
        planetFrom.setId("MARS");
        planetFrom.setName("Mars");
        planetService.create(planetFrom);
        System.out.println("Planet created: " + planetFrom.getName());

        Planet planetTo = new Planet();
        planetTo.setId("EARTH");
        planetTo.setName("Earth");
        planetService.create(planetTo);
        System.out.println("Planet created: " + planetTo.getName());

        // **Читання даних Client**
        Client fetchedClient = clientService.read(client.getId());
        System.out.println("Fetched Client: " + fetchedClient.getName());

        // **Читання даних Planet**
        Planet fetchedPlanet = planetService.read(planetFrom.getId());
        System.out.println("Fetched Planet: " + fetchedPlanet.getName());

        // **Оновлення Client**
        fetchedClient.setName("Jane Doe");
        clientService.update(fetchedClient);
        System.out.println("Client updated: " + fetchedClient.getName());

        // **Видалення Planet**
        planetService.delete(planetTo.getId());
        System.out.println("Planet deleted: " + planetTo.getId());

        // Закриття SessionFactory
        sessionFactory.close();
    }
}