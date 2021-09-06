package com.isi.dao;

import com.isi.entities.Annee;
import com.isi.entities.Etudiant;
import com.isi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Long> {
    @Query("select u from User u where u.email = :mail AND u.password=:pwd")
    public User findUserByEmailAndPassword(@Param("mail")String mail,@Param("mail")String pwd);
}
