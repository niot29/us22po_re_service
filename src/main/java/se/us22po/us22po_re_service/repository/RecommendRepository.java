package se.us22po.us22po_re_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.us22po.us22po_re_service.entity.Recommendation;

import java.util.List;

@Repository
public interface RecommendRepository extends JpaRepository<Recommendation, Integer> {
     public boolean existsByEmail(String email);

     public List<Recommendation> findByEmail(String email);
     @Query("select max(s.id) from Recommendation s")
    public  Integer findByMaxId();

}
