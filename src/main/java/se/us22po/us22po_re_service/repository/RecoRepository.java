package se.us22po.us22po_re_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.us22po.us22po_re_service.entity.RecoEntity;

import java.util.List;

@Repository
public interface RecoRepository extends JpaRepository<RecoEntity, Integer> {

    boolean existsByEmail(String email);

    boolean existsById(Integer id);

    List<RecoEntity> findByEmail(String email);

    @Query("select max(s.id) from RecoEntity s")
    Integer findByMaxId();

    void deleteAllById(Integer id);
    void deleteAllByProductId(Integer id);



}
