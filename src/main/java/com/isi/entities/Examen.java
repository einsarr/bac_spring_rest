package com.isi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandomParameters;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Examen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle_examen;
    @OneToMany(mappedBy = "examen",fetch = FetchType.EAGER)
    private List<EtudiantExamen> etudiantExamenList;
    @ManyToOne
    private Annee annee;
    @OneToMany(mappedBy = "examen")
    private List<Epreuve> epreuveList;

    @ManyToOne
    private User user;

    public Examen(Long id, String libelle_examen, Annee annee) {
        this.id = id;
        this.libelle_examen = libelle_examen;
        this.annee = annee;
    }
}
