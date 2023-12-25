package my.app.userservice.bean;

import jakarta.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    @Column(length = 45, nullable = false)
    private String cin;
    private double year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Terrain getterrain() {
        return terrain;
    }

    public void setterrain() {
        this.terrain = terrain;
    }

    public String getcin() {
        return cin;
    }

    public void setcin(String password) {
        this.cin = cin;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", terrain='" + terrain + '\'' +
                ", cin='" + cin + '\'' +
                '}';
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }
}
