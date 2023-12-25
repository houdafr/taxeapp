package my.app.taxeservice.repository;

import my.app.taxeservice.bean.Taux;
import my.app.taxeservice.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TauxRepository extends JpaRepository<Taux, Long> {
        Optional<Taux> findByTerrain(Terrain terrain);
    }

