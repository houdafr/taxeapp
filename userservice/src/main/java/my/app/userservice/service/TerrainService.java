package my.app.userservice.service;
import my.app.userservice.bean.Categorie;
import my.app.userservice.bean.Terrain;
import my.app.userservice.bean.User;
import my.app.userservice.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    @Autowired
    private static  TerrainRepository terrainRepository;
   /* public static Terrain getTerrainByCategorie(Categorie categorie) {

        Optional<Terrain> optionalTerrain = terrainRepository.findByCategorie(categorie);

        return optionalTerrain.orElse(null);
    }*/
    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }


    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public Terrain updateTerrain(Long id, Terrain updatedTerrain) {
        Optional<Terrain> existingTerrainOptional = terrainRepository.findById(id);

        if (existingTerrainOptional.isPresent()) {
            Terrain existingTerrain = existingTerrainOptional.get();
            existingTerrain.setCategorie(updatedTerrain.getCategorie());
            existingTerrain.setDatedernierpaiment(updatedTerrain.getDatedernierpaiment());
            existingTerrain.setUser(updatedTerrain.getUser());

            return terrainRepository.save(existingTerrain);
        } else {
            return null; // Handle not found case
        }
    }

    public void deleteTerrain(Long id) {
        terrainRepository.deleteById(id);
    }
    public Terrain save(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public Terrain getTerrainByUser(User user) {Optional<Terrain> terrainOptional = terrainRepository.findByUser(user);

        return terrainOptional.orElse(null);
    }
 /*   public Terrain getTerrainByCin(String cin) {
        User user = userService.getUserByCin(cin);
        return terrainService.getTerrainByUser(user);
    }*/

}
