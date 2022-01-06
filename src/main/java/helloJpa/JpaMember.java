package helloJpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class JpaMember {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

    // 단방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private JpaTeam jpateam;

    @Embedded
    private Peroid workPeroid;
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
            @JoinColumn(name = "MEMBER_ID")
    )
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
            @JoinColumn(name = "MEMBER_ID")
    )
    private List<Address> addressHistory = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "MEMBER_ID")
//    private List<AddressEntity> addressHistory = new ArrayList<>();



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
    }

    public Peroid getWorkPeroid() {
        return workPeroid;
    }

    public void setWorkPeroid(Peroid workPeroid) {
        this.workPeroid = workPeroid;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }


//    public List<AddressEntity> getAddressHistory() {
//        return addressHistory;
//    }
//
//    public void setAddressHistory(List<AddressEntity> addressHistory) {
//        this.addressHistory = addressHistory;
//    }
}
