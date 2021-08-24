package com.isi;

import com.isi.dao.*;
import com.isi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public static void main(String[] args) {
		SpringApplication.run(BacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d = sdf.parse("2000-02-02");
		}catch (Exception e){
			e.printStackTrace();
		}
		/*etudiantDao.save(new Etudiant(null,"544B120","Nicephor","Iloky",d,"BRAZA"));
		etudiantDao.save(new Etudiant(null,"32B120","Moussa","DIOP",d,"BRAZA"));
		anneeDao.save(new Annee(null,2021));
		examenDao.save(new Examen(null,"Baccalaureat de philo",anneeDao.getById(1L)));
		resultatDao.save(new Resultat(null,d,true));
		etudiantExamenDao.save(new EtudiantExamen(null,examenDao.getById(1L),etudiantDao.getById(1L),resultatDao.getById(1L)));
*/
		etudiantExamenDao.findAll().forEach(e->{
			System.out.println(e.getEtudiant().getPrenom());
		});
	}
}
