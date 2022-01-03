package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class JpaMember {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    // 단방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private JpaTeam jpateam;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JpaTeam getJpateam() {
        return jpateam;
    }

    public void setJpateam(JpaTeam jpateam) {
        this.jpateam = jpateam;
//        jpateam.getMembers().add(this);
    }
}
