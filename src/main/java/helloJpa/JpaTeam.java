package helloJpa;

import helloJpa.domain.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JpaTeam {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    // 양방향 연관관계
    @OneToMany(mappedBy = "jpateam")
    private List<JpaMember> members = new ArrayList<>();

    public void addMember(JpaMember member) {
        member.setJpateam(this);
        members.add(member);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JpaMember> getMembers() {
        return members;
    }

    public void setMembers(List<JpaMember> members) {
        this.members = members;
    }
}
