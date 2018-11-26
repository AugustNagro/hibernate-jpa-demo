package yolo.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("hibernatedemo").createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Leon");
        Person p1 = new Person("David");
        em.persist(p);
        em.persist(p1);
        em.getTransaction().commit();

        List<Person> people = em.createQuery("select p from Person p", Person.class).getResultList();
        for (Person person : people) System.out.println(person.getName());
        em.getEntityManagerFactory().close();
    }
}
