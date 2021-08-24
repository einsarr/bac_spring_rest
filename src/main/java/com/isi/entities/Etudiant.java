package com.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String prenom;
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_naissance;
    private String lieu_naissance;

    public Etudiant(Long id, String matricule, String prenom, String nom, Date date_naissance, String lieu_naissance) {
        this.id = id;
        this.matricule = matricule;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
    }

    @OneToMany(mappedBy = "etudiant",fetch = FetchType.EAGER)
    private List<EtudiantExamen> etudiantExamenList;
}
