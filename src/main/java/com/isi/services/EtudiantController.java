package com.isi.services;

import com.isi.dao.IEtudiant;
import com.isi.entities.Etudiant;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EtudiantController {

    private final IEtudiant etudiantDao;
    public EtudiantController(IEtudiant etudiantDao){
        this.etudiantDao = etudiantDao;
    }

    @RequestMapping(value = "/etudiants",method = RequestMethod.GET)
    public List<Etudiant> getAll(){
        return etudiantDao.findAll();
    }

    @RequestMapping(value = "/etudiants/{id}",method = RequestMethod.GET)
    public Etudiant getEtudiant(@PathVariable Long id){
        return etudiantDao.findById(id).get();
    }

    @RequestMapping(value = "/getEtudiant",method = RequestMethod.GET)
    public Etudiant getEtudiantByLib(@RequestParam String mat){
        return etudiantDao.findByMatricule(mat);
    }

    @RequestMapping(value="/etudiants/{id}",method = RequestMethod.PUT)
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable Long id) {

        return etudiantDao.findById(id)
                .map(etud -> {
                    etud.setMatricule(etudiant.getMatricule());
                    etud.setPrenom(etudiant.getPrenom());
                    etud.setNom(etudiant.getNom());
                    etud.setDate_naissance(etudiant.getDate_naissance());
                    etud.setLieu_naissance(etudiant.getLieu_naissance());
                    return etudiantDao.save(etud);
                })
                .orElseGet(() -> {
                    etudiant.setId(id);
                    return etudiantDao.save(etudiant);
                });
    }
    @PostMapping("/etudiants")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    @DeleteMapping("/etudiant/{id}")
    public int deleteEtudiants(@PathVariable Long id) {
        etudiantDao.deleteById(id);
        return 1;
    }

    @RequestMapping(value="/etudiants/{id}",method = RequestMethod.DELETE)
    public List<Etudiant> deleteEtudiant(@PathVariable Long id) {
        if(id!=null)  etudiantDao.deleteById(id);
        return etudiantDao.findAll();
    }
}
