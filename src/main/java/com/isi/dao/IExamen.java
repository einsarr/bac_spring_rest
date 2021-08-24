package com.isi.dao;

import com.isi.entities.EtudiantExamen;
import com.isi.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamen extends JpaRepository<Examen,Long> {
}
