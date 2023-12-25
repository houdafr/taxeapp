package my.app.taxeservice.repository;

import my.app.taxeservice.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CategorieRepository extends JpaRepository<Categorie, Long> {
        // You can add custom query methods here if needed
    }
