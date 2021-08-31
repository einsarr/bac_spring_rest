package com.isi;

import com.isi.dao.*;
import com.isi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class BacApplication implements CommandLineRunner {
	@Autowired
	private IAnnee anneeDao;
	@Autowired
	private IExamen examenDao;
	@Autowired
	private IEtudiant etudiantDao;
	@Autowired
	private IResultat resultatDao;
	@Autowired
	private IEtudiantExamen etudiantExamenDao;
	@Autowired
	private IEpreuve epreuveDao;

	@Autowired
	private IUser userDao;

	@Autowired
	private IRole roleDao;

	public static void main(String[] args) {
		SpringApplication.run(BacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Date d = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			d = sdf.parse("2000-02-02");
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		etudiantDao.save(new Etudiant(null,"544B120","Nicephor","Iloky",d,"BRAZA"));
//		etudiantDao.save(new Etudiant(null,"32B120","Moussa","DIOP",d,"BRAZA"));
//		anneeDao.save(new Annee(null,2021));
//		examenDao.save(new Examen(null,"Baccalaureat de philo",anneeDao.getById(1L)));
//		resultatDao.save(new Resultat(null,d,true));
//		etudiantExamenDao.save(new EtudiantExamen(null,examenDao.getById(1L),etudiantDao.getById(1L),resultatDao.getById(1L)));
//
//		Role r = new Role();
//		r.setLibelle_role("ROLE_SUPER");
//		Role r1 = new Role();
//		r1.setLibelle_role("ROLE_TECHNICIEN");
//		roleDao.save(r);
//		roleDao.save(r1);
//
//		List<Role> lRoles = new ArrayList<>();
//		lRoles.add(r);
//		lRoles.add(r1);
//
//		lRoles.add(roleDao.getById(2L));
//
//		User u = new User();
//		u.setPrenom("Ablaye");
//		u.setNom("CISSE");
//		u.setEmail("cissand@gmail.com");
//		//cryp password
//		String pwd = "passer123";
//		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		String hashedPwd = pwdEncoder.encode(pwd);
//		u.setPassword(hashedPwd);
//		u.setEtat(1);
//		u.setRoles(lRoles);
//		userDao.save(u);

	}
}
