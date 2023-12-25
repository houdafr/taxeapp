package my.app.userservice.bean;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "categorie")
    private List<Terrain> terrains;

    @OneToMany(mappedBy = "categorie")
    private List<Taux> taux;


    @Override
    public String toString() {
        return "com.sir.taxeTNBapi.bean.CategorieTnb[ id=" + id + " ]";
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public void setTaux(List<Taux> taux) {
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
