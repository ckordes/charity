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

    @Query (value = "select * from donation d inner join donation_status ds on ds.id = d.donation_status_id inner join user u on u.id = ds.user_id where u.id = ? order by ds.picked_up_date desc, ds.created_date_entry desc ;",
            nativeQuery = true)
    List<Donation> findAllMyDonations (long id);

}
