package be.thomasmore.app.repositories;

import be.thomasmore.app.model.CodingLanguage;
import be.thomasmore.app.model.FrameworkEngine;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;

public interface FrameworkEngineRepository  extends CrudRepository<FrameworkEngine, Integer> {

    @Query("SELECT f FROM FrameworkEngine f where (:paidForStudents IS NULL OR f.paidForStudents= :paidForStudents) AND " +
            "(:paidForCompany IS NULL OR f.paidForCompany= :paidForCompany)")
    List<FrameworkEngine> findFilters(@Param("paidForStudents") Boolean paidForStudents,
                                      @Param("paidForCompany") Boolean paidForCompany);
}
