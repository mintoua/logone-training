package logonedigital.springcourse.repositories;

import logonedigital.springcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE MONTH(u.creationDate) " +
            "= MONTH(CURRENT_DATE) AND YEAR(u.creationDate) = YEAR(CURRENT_DATE)")
    List<User> findUtilisateursAjoutesCeMois();
}
