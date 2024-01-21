package bdbt_bada_project.SpringApplication.Repository;

import bdbt_bada_project.SpringApplication.Entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {



}
