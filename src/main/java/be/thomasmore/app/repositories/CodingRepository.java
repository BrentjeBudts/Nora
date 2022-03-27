package be.thomasmore.app.repositories;

import be.thomasmore.app.model.CodingLanguage;
import be.thomasmore.app.model.FrameworkEngine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodingRepository extends CrudRepository<CodingLanguage, Integer> {
    @Query("SELECT c FROM CodingLanguage c where (:objectOriented IS NULL OR c.objectOriented = :objectOriented)")
    List<CodingLanguage> findFilters(@Param("objectOriented") Boolean objectOriented);
}
