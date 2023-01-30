package se.us22po.us22po_re_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.us22po.us22po_re_service.entity.RecoEntity;

import java.util.List;

@Repository
public interface RecoRepository extends JpaRepository<RecoEntity, Integer> {

    boolean existsById(Integer id);

    List<RecoEntity> findByProductId(int productId);
    List<RecoEntity> findByProductIdAndStatus(int productId, int status);


    // List<RecoEntity> findByEmail(String email);

    // void deleteAllById(Integer id);
    void deleteAllByProductId(Integer productId);



}
