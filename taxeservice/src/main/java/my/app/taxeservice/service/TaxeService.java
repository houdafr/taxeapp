package my.app.taxeservice.service;

import my.app.taxeservice.bean.Taxe;
import my.app.taxeservice.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {
    @Autowired
    private static TaxeRepository taxeRepository;

    @Autowired
    public TaxeService(TaxeRepository taxeRepository) {
        this.taxeRepository = taxeRepository;
    }

    //public List<Taxe> getAllTaxes() {return taxeRepository.findAll();}

    public Taxe getTaxeById(Long id) {
        Optional<Taxe> optionalTaxe = taxeRepository.findById(id);
        return optionalTaxe.orElse(null);
    }

    public Taxe createTaxe(Taxe taxe) {
        // You can add additional business logic or validation here if needed
        return taxeRepository.save(taxe);
    }

    public Taxe updateTaxe(Long id, Taxe updatedTaxe) {
        Optional<Taxe> optionalTaxe = taxeRepository.findById(id);
        if (optionalTaxe.isPresent()) {
            // Update the existing taxe with the new data
            Taxe existingTaxe = optionalTaxe.get();
            existingTaxe.setTaux(updatedTaxe.getTaux());
            existingTaxe.setTerrain(updatedTaxe.getTerrain());
            // Update other fields as needed

            return taxeRepository.save(existingTaxe);
        }
        return null; // or throw an exception indicating that the taxe with the given id was not found
    }

    //public void deleteTaxe(Long id) {taxeRepository.deleteById(id);}
}
