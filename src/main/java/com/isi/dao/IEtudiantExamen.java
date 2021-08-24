package com.isi.dao;

import com.isi.entities.EtudiantExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantExamen extends JpaRepository<EtudiantExamen,Long> {
}
