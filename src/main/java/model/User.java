package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean isActive;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<AdverseReaction> adrs = new HashSet<>();

    private UserType type;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", password=" + password +
                ", active=" + isActive +
                ", adverse reactions=" + adrs +
                "}";
    }
}


