package bdbt_bada_project.SpringApplication.Repository;

import bdbt_bada_project.SpringApplication.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long> {
}
