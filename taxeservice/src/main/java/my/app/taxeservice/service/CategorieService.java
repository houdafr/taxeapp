package my.app.taxeservice.service;


import my.app.taxeservice.bean.Categorie;
import my.app.taxeservice.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CategorieService {

        private final CategorieRepository categorieRepository;

        @Autowired
        public CategorieService(CategorieRepository categorieRepository) {
            this.categorieRepository = categorieRepository;
        }

        public List<Categorie> getAllCategories() {
            return categorieRepository.findAll();
        }

        public Categorie getCategoryById(Long id) {
            Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
            return optionalCategorie.orElse(null);
        }

        public Categorie createCategory(Categorie categorie) {
            // You can add additional business logic or validation here if needed
            return categorieRepository.save(categorie);
        }

        public Categorie updateCategory(Long id, Categorie updatedCategorie) {
            Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
            if (optionalCategorie.isPresent()) {
                // Update the existing category with the new data
                Categorie existingCategorie = optionalCategorie.get();

                return categorieRepository.save(existingCategorie);
            }
            return null; // or throw an exception indicating that the category with the given id was not found
        }

        public void deleteCategory(Long id) {
            categorieRepository.deleteById(id);
        }
    }

