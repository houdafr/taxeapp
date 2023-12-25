package my.app.taxeservice.controller;

import my.app.taxeservice.bean.Categorie;
import my.app.taxeservice.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/categories")
    public class CategorieController {

        private final CategorieService categorieService;

        @Autowired
        public CategorieController(CategorieService categorieService) {
            this.categorieService = categorieService;
        }

        @GetMapping
        public List<Categorie> getAllCategories() {
            return categorieService.getAllCategories();
        }

        @GetMapping("/{id}")
        public Categorie getCategoryById(@PathVariable Long id) {
            return categorieService.getCategoryById(id);
        }

        @PostMapping
        public Categorie createCategory(@RequestBody Categorie categorie) {
            return categorieService.createCategory(categorie);
        }

        @PutMapping("/{id}")
        public Categorie updateCategory(@PathVariable Long id, @RequestBody Categorie categorie) {
            return categorieService.updateCategory(id, categorie);
        }

        @DeleteMapping("/{id}")
        public void deleteCategory(@PathVariable Long id) {
            categorieService.deleteCategory(id);
        }
    }

