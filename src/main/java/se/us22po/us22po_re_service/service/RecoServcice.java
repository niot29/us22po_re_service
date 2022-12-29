package se.us22po.us22po_re_service.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.us22po.us22po_re_service.entity.RecoEntity;
import se.us22po.us22po_re_service.repository.RecoRepository;


import java.util.List;

@Service
public class RecoServcice {
    private final Logger logger = LoggerFactory.getLogger(RecoServcice.class);

    @Autowired
    private RecoRepository reco;

    public List<RecoEntity> allRec(){
        return reco.findAll();
    }

    @Transactional
    public String createRecom(RecoEntity recom){
        try{
            RecoEntity r = new RecoEntity();
            r.setProductName(recom.getProductName());
            r.setProductId(recom.getProductId());
            r.setEmail(recom.getEmail());
            r.setComment(recom.getComment());
            r.setRating(recom.getRating());
            r.setStatus(1);

            reco.save(recom);
        }catch (Exception e){
            throw e;
        }
        return "Msg add to database";
    }

    @Transactional
    public String diactivetRecomByProdId(Integer productId){
        reco.deleteAllByProductId(productId);
        return "Msg on product is deleted";
    }
}
