package com.isi.dao;

import com.isi.entities.Annee;
import com.isi.entities.Etudiant;
import com.isi.entities.EtudiantExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnnee extends JpaRepository<Annee,Long> {
    @Query("SELECT annee FROM Annee annee WHERE annee.libelle_anne =:lib")
    public Annee findByLibelle_anne(@Param("lib")int lib);
}
