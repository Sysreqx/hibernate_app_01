package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//######## get items
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//            System.out.println(items);

//######## get an owner
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);

//######## Add an item
//            Person person = session.get(Person.class, 2);
//
//            Item item = new Item("Item from Hibernate", person);
//
//            person.getItems().add(item);
//
//            session.save(item);

//######## Add a person
//            Person person = new Person("person#1 from hibernate", 30);
//
//            Item item = new Item("item#2 from hibernate", person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//
//            session.save(person);
//            session.save(item);

//######## Delete a person
//            Person person = session.get(Person.class, 2);
//
//            session.remove(person);
//
//            person.getItems().forEach(i -> i.setOwner(null));

//######## Change an owner
            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);

            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
