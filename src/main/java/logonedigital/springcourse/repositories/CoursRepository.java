package logonedigital.springcourse.repositories;

import logonedigital.springcourse.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

}
