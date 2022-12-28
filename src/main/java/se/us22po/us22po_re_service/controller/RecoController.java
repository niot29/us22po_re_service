package se.us22po.us22po_re_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.us22po.us22po_re_service.entity.Recommendation;
import se.us22po.us22po_re_service.repository.RecommendRepository;
import se.us22po.us22po_re_service.service.RecommendationServcice;

import java.util.List;

@RestController
public class RecoController {

    @Autowired
    private RecommendationServcice recoService;

    @GetMapping(value = "info")
    public String info(){
        return "The application is uo ..";
    }

    @PostMapping(value = "createrecommendation")
    public String createReco(@RequestBody Recommendation reco){
        return recoService.createRecom(reco);
    }

    @GetMapping(value = "getRecoList")
    public List<Recommendation> getRecoList(){
        return recoService.allRec();
    }
}
