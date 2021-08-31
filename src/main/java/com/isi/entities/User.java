package com.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    private String email;
    private String prenom;
    private String nom;
    private String password;
    private int etat;
    @ManyToMany
    List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Examen> examens = new ArrayList<>();

}
