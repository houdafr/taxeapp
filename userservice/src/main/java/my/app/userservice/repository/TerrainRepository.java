package my.app.userservice.repository;

import my.app.userservice.bean.Categorie;
import my.app.userservice.bean.Terrain;
import my.app.userservice.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
      Optional<Terrain> findByCategorie(Categorie categorie);

      Optional<Terrain> findByUser(User user);
}
