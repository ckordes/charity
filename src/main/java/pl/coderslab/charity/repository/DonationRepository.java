package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
    Donation findById(long  id);

    @Query("select count(d) from Donation d ")
    long donationCount();

    @Query("select sum(d.quantity) from Donation d ")
    long quantityCount();

    Donation  findFirstByOrderByIdDesc();

    @Query("SELECT DISTINCT(d.institution) FROM Donation d")
    List<Institution> sumSupportedInstitutions();

}
