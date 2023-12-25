package my.app.userservice.bean;

import jakarta.persistence.*;

@Entity
    public class Terrain {
        @Id
        private Long id;
        private double surface;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "categorie_id")
        private Categorie categorie;
        private Integer datedernierpaiment;
        @ManyToOne
        private User user;


        public Categorie getCategorie() {
            return categorie;
        }

        public void setCategorie(Categorie categorie) {
            this.categorie = categorie;
        }
        public double getSurface() {
        return surface;
    }


    public Integer getDatedernierpaiment() {
            return datedernierpaiment;
        }

        public void setDatedernierpaiment(Integer datedernierpaiment) {
            this.datedernierpaiment = datedernierpaiment;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }


