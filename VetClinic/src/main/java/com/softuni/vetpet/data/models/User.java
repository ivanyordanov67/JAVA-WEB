package com.softuni.vetpet.data.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private Role role;
    //private List<Pet> pets;

    public User() {
        //this.pets = new ArrayList<>();
    }

    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(com.softuni.vetpet.data.models.Role role) {
        this.role = role;
    }

//    @OneToMany(targetEntity = Pet.class, mappedBy = "owner")
//   // @JoinColumn(name = "owner_id", referencedColumnName = "id", updatable = true)
//    public List<Pet> getPets() {
//        return pets;
//    }
//
//    public void setPets(List<com.softuni.vetpet.data.models.Pet> pets) {
//        this.pets = pets;
//    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
