package my.app.userservice.controller;

import my.app.userservice.bean.Terrain;
import my.app.userservice.bean.User;
import my.app.userservice.service.TerrainService;
import my.app.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terrains")
public class TerrainController {

    private static TerrainService terrainService;
    private static UserService userService;

    @Autowired
    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    @PostMapping("/save")
    public Terrain saveTerrain(@RequestBody Terrain terrain) {
        // Effectuer des validations, des traitements ou des opérations supplémentaires si nécessaire
        return terrainService.save(terrain);}

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        return terrainService.createTerrain(terrain);
    }

    @PutMapping("/updateterrain/{id}")
    public Terrain updateTerrain(@PathVariable Long id, @RequestBody Terrain updatedTerrain) {
        return terrainService.updateTerrain(id, updatedTerrain);
    }

    @DeleteMapping("/deleteterrain/{id}")
    public void deleteTerrain(@PathVariable Long id) {
        terrainService.deleteTerrain(id);
    }
    @GetMapping("/byUser/{userId}")
    public ResponseEntity<Terrain> getTerrainByUser(@PathVariable Long userId) {
        // Utilisez un service ou un référentiel pour obtenir l'objet User en fonction de l'ID
        User user = userService.getUserById(userId);

        if (user != null) {
            Terrain terrain = terrainService.getTerrainByUser(user);
            if (terrain != null) {
                return new ResponseEntity<>(terrain, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
