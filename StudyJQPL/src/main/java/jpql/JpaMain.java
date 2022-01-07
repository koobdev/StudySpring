package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.regex.MatchResult;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try{

//            Member member = new Member();
//            member.setUserName("member1");
//            member.setAge(20);
//            em.persist(member);
//
//            em.flush();
//            em.clear();


            // Query 타입조회
//            System.out.println("username = " + result.get(0).getUserName());
//            System.out.println("age = " + result.get(0).getAge());

            // Object 조회
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//
//            System.out.println("result = " + result[0]);
//            System.out.println("result = " + result[1]);

            // new 타입조회
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.userName, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            for (MemberDTO m : resultList) {
//                System.out.println("userName = " + m.getUserName());
//                System.out.println("age = " + m.getAge());
//            }

            // 페이징
//            for(int i=1; i<100; i++){
//                Member member = new Member();
//                member.setUserName("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
            List<Member> result = em.createQuery("select m from Member m order by m.age asc ", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(20)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getUserName() = " + member.getUserName());
                System.out.println("member.getAge() = " + member.getAge());
            }




            ts.commit();
        }catch (Exception e){
            ts.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();
    }
}
