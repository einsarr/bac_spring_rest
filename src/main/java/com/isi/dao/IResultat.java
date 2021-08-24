package com.isi.dao;

import com.isi.entities.EtudiantExamen;
import com.isi.entities.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultat extends JpaRepository<Resultat,Long> {
}
