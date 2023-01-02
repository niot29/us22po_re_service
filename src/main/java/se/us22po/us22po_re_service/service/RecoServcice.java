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

    /**
     * List all record
     * @return List
     */
    public List<RecoEntity> allRec(){
        logger.info("allRec()");
        return reco.findAll();
    }

    /**
     * List all record on query with define parameter
     * @param productId record id in  product
     * @return List
     */
    public List<RecoEntity> allProductRec(int productId){
        logger.info("allProductRec({})",productId);
        return reco.findByProductId(productId);
    }

    /**
     * Insert a new record, (remove the ID if is ass passthroughs)
     * @param recom Obejct entity
     * @return String msg
     */
    @Transactional
    public String createRecom(RecoEntity recom){
        logger.info("createRecom()");
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
            logger.error("Something is wrong on adding object");
            throw e;

        }
        return "Msg add to database";
    }


    /**
     * Some work with deactivate, right now it just delete the db record.
     * Need update the status and set it to 0 for deactivate the record.
     * @param productId record id in  product
     */
    @Transactional
    public void diactivetRecomByProdId(int productId){
        logger.info("diactivetRecomByProdId()");
        reco.deleteAllByProductId(productId);
    }

    /**
     *  Delte the record from db
     * @param productId record id in  product
     */
    @Transactional
    public void deleteRecomByProdId(int productId){
        logger.info("deleteRecomByProdId()");
        reco.deleteAllByProductId(productId);
    }
}
