package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import project.model.Cup;

import java.util.List;

public interface CupRepository extends JpaRepository<Cup, Long> {
    List<Cup> findByNumber(String number);

}
