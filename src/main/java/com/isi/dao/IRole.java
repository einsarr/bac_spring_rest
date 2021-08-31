package com.isi.dao;

import com.isi.entities.Annee;
import com.isi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole extends JpaRepository<Role,Long> {

}
