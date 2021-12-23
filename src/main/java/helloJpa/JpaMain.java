package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try{
            /*  // 회원 저장
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");
             */

            /*  // 회원 조회
            Member member = em.find(Member.class, 1L);
            System.out.println("member id = " + member.getId());
            System.out.println("member name = " + member.getName());


            // JPQL사용
            List<Member> memberList = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            for (Member member : memberList) {
                System.out.println("member1 = " + member.getName());
            }
            */

            /*  // 회원 삭제
            Member member = em.find(Member.class, 1L);
            em.remove(member);
            */

            /*  // 회원 수정
            Member member = em.find(Member.class, 1L);
            member.setName("helloC");
            // em.persist(member)안해도 됨..!
             */

//            Member member = em.find(Member.class, 1L);
            List<Member> memberList = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            for (Member member : memberList) {
                System.out.println("member1 = " + member.getName());
            }

//            em.persist(member);
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
