package my.app.taxeservice.service;

import my.app.taxeservice.bean.Taux;
import my.app.taxeservice.bean.Terrain;
import my.app.taxeservice.repository.TauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TauxService {
    @Autowired
    private static TauxRepository tauxRepository;

    //public static void saveTaux(Taux taux) {}

    /*public Taux getTauxByTerrain(Terrain terrain) {

        Optional<Taux> optionalTaux = tauxRepository.findByTerrain(terrain);

        return optionalTaux.orElse(null);
    }*/


    @Autowired
    public TauxService(TauxRepository tauxRepository) {
        this.tauxRepository = tauxRepository;
    }

    public List<Taux> getAllTaux() {
        return tauxRepository.findAll();
    }

    public Taux getTauxById(Long id) {
        Optional<Taux> optionalTaux = tauxRepository.findById(id);
        return optionalTaux.orElse(null);
    }

    public Taux createTaux(Taux taux) {
        // You can add additional business logic or validation here if needed
        return tauxRepository.save(taux);
    }

    public Taux updateTaux(Long id, Taux updatedTaux) {
        Optional<Taux> optionalTaux = tauxRepository.findById(id);
        if (optionalTaux.isPresent()) {
            // Update the existing taux with the new data
            Taux existingTaux = optionalTaux.get();
            // Update other fields as needed

            return tauxRepository.save(existingTaux);
        }
        return null; // or throw an exception indicating that the taux with the given id was not found
    }

    public void deleteTaux(Long id) {
        tauxRepository.deleteById(id);
    }

    
}

