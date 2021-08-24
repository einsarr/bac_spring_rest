package com.isi.services;

import com.isi.dao.IAnnee;
import com.isi.entities.Annee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnneeController {
    private final IAnnee anneeDao;
    public AnneeController(IAnnee anneeDao){
        this.anneeDao = anneeDao;
    }
    @RequestMapping(value = "/annees",method = RequestMethod.GET)
    public List<Annee> getAll(){
        return anneeDao.findAll();
    }
/*
    @RequestMapping(value = "/annees",method = RequestMethod.GET)
    public Annee getAnnee(){
        return anneeDao.findAll();
    }

    @RequestMapping(value = "/annees",method = RequestMethod.GET)
    public List<Annee> getAll(){
        return anneeDao.findAll();
    }

    @RequestMapping(value = "/annees",method = RequestMethod.GET)
    public List<Annee> getAll(){
        return anneeDao.findAll();
    }

    @RequestMapping(value = "/annees",method = RequestMethod.GET)
    public List<Annee> getAll(){
        return anneeDao.findAll();
    }*/
}
