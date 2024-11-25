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


        Planet planetFrom = new Planet();

        planetFrom.setName("Mars");
        planetService.create(planetFrom);

        Planet planetTo = new Planet();

        planetTo.setName("Earth");
        planetService.create(planetTo);
        System.out.println("Planet created: " + planetTo.getName());


        Client fetchedClient = clientService.read(client.getId());
        System.out.println("Fetched Client: " + fetchedClient.getName());


        Planet fetchedPlanet = planetService.read(1L);
        if (fetchedPlanet == null) {
            System.out.println("Planet not found for ID: " +1L);
        } else {
            System.out.println("Fetched Planet: " + fetchedPlanet.getName());
        }



        fetchedClient.setName("Jane Doe");
        clientService.update(fetchedClient);
        System.out.println("Client updated: " + fetchedClient.getName());


        planetService.delete(planetTo.getId());
        System.out.println("Planet deleted: " + planetTo.getId());


        sessionFactory.close();
    }
}