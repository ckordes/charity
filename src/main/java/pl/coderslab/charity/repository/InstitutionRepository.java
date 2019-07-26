package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Institution;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    Institution findById(long id);

    @Query("select count(i) from Institution i")
    long institutionCount();
}
