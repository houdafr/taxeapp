package my.app.taxeservice.repository;

import my.app.taxeservice.bean.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Long> {
    // You can add custom query methods here if needed
}
