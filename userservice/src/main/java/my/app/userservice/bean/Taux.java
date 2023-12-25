package my.app.userservice.bean;
import jakarta.persistence.*;
@Entity
    public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    private double montantParMetreCarre;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getMontantParMetreCarre() {
        return montantParMetreCarre;
    }

    public void setMontantParMetreCarre(double montantParMetreCarre) {
        this.montantParMetreCarre = montantParMetreCarre;
    }

    public Terrain getTerrain() {
        return terrain;
    }
    public Taux() {

    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public Taux(double surface, double montantParMetreCarre, Terrain terrain) {
        this.montantParMetreCarre = montantParMetreCarre;
        this.terrain = terrain;
    }
}




