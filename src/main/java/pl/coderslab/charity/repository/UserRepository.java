package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Query(value = "select * from user u inner join user_role ur on u.id = ur.user_id inner join role r on ur.role_id = r.id where r.name = 'ADMIN';",
            nativeQuery = true)
    List<User> findAllAdmins();

    @Query(value = "select * from user u inner join user_role ur on u.id = ur.user_id inner join role r on ur.role_id = r.id where r.name <> 'ADMIN';",
            nativeQuery = true)
    List<User> findAllUsers();
}
