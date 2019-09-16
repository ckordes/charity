package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;
@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    Institution findById(long id);

    @Query("select count(i) from Institution i")
    long institutionCount();
}
