package com.isi.services;

import com.isi.dao.IAnnee;
import com.isi.entities.Annee;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/annees/{id}",method = RequestMethod.GET)
    public Annee getAnnee(@PathVariable Long id){
        return anneeDao.findById(id).get();
    }

    @RequestMapping(value = "/getAnnee",method = RequestMethod.GET)
    public Annee getAnneeByLib(@RequestParam int lib){
        return anneeDao.findByLibelle_anne(lib);
    }

    @RequestMapping(value="/annees/{id}",method = RequestMethod.PUT)
    public Annee updateAnnee(@RequestBody Annee annee, @PathVariable Long id) {

        return anneeDao.findById(id)
                .map(an -> {
                    an.setLibelle_anne(annee.getLibelle_anne());
                    return anneeDao.save(an);
                })
                .orElseGet(() -> {
                    annee.setId(id);
                    return anneeDao.save(annee);
                });
    }
    @PostMapping("/annees")
    public Annee saveAnnee(@RequestBody Annee annee) {
        return anneeDao.save(annee);
    }

    @DeleteMapping("/annee/{id}")
    public int deleteAnnees(@PathVariable Long id) {
         anneeDao.deleteById(id);
         return 1;
    }

    @RequestMapping(value="/annees/{id}",method = RequestMethod.DELETE)
    public List<Annee> deleteAnnee(@PathVariable Long id) {
        if(id!=null)  anneeDao.deleteById(id);
        return anneeDao.findAll();
    }
}
