package my.app.taxeservice.controller;

import my.app.taxeservice.bean.Taux;
import my.app.taxeservice.service.TauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taux")
public class TauxController {
    @Autowired
    private final TauxService tauxService;

    @Autowired
    public TauxController(TauxService tauxService) {
        this.tauxService = tauxService;
    }

    @GetMapping
    public List<Taux> getAllTaux() {
        return tauxService.getAllTaux();
    }

    @GetMapping("/{id}")
    public Taux getTauxById(@PathVariable Long id) {
        return tauxService.getTauxById(id);
    }

    @PostMapping
    public Taux createTaux(@RequestBody Taux taux) {
        return tauxService.createTaux(taux);
    }

    @PutMapping("/{id}")
    public Taux updateTaux(@PathVariable Long id, @RequestBody Taux updatedTaux) {
        return tauxService.updateTaux(id, updatedTaux);
    }

    @DeleteMapping("/{id}")
    public void deleteTaux(@PathVariable Long id) {
        tauxService.deleteTaux(id);
    }
}
