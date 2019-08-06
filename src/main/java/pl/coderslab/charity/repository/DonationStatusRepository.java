package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.DonationStatus;


@Repository
public interface DonationStatusRepository extends JpaRepository<DonationStatus, Long> {
    DonationStatus findById(long id);

    DonationStatus findFirstByOrderByIdDesc();

}