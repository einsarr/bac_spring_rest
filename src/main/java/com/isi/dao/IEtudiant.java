package com.isi.dao;

import com.isi.entities.Etudiant;
import com.isi.entities.EtudiantExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiant extends JpaRepository<Etudiant,Long> {
    @Query("SELECT etudiant FROM Etudiant etudiant WHERE etudiant.matricule=:mat")
    public Etudiant findByMatricule(@Param("mat")String mat);
}
