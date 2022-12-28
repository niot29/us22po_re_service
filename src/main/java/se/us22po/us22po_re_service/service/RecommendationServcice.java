package se.us22po.us22po_re_service.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.us22po.us22po_re_service.entity.Recommendation;
import se.us22po.us22po_re_service.repository.RecommendRepository;

import java.beans.Transient;
import java.util.List;

@Service
public class RecommendationServcice {

    @Autowired
    private RecommendRepository reco;

    public List<Recommendation> allRec(){
        return reco.findAll();
    }
    @Transactional
    public String createRecom(Recommendation recom){
        try{
            reco.save(recom);
        }catch (Exception e){
            throw e;
        }
        return "Msg add to database";
    }


}
