package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

//            Order order = new Order();
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

//            Album album = new Album();
//            album.setArtist("kim");
//            album.setName("album1");
//            album.setPrice(10000);
//            em.persist(album);
//
//            Book book = new Book();
//            book.setAuthor("Lee");
//            book.setIsbn("1234");
//            book.setName("book1");
//            book.setPrice(8000);
//            em.persist(book);
//
//            em.flush();
//            em.clear();
//
//            Book findBook = em.find(Book.class, book.getId());
//            System.out.println("findBook = " + findBook);



            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);
            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);


            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
