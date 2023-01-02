package se.us22po.us22po_re_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.us22po.us22po_re_service.entity.RecoEntity;
import se.us22po.us22po_re_service.service.RecoServcice;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendations")
public class RecoController {
    private final Logger logger = LoggerFactory.getLogger(RecoController.class);

    @Autowired
    private RecoServcice recoService;

    @GetMapping(value = "info")
    public String info(){
        return "The application is up ..";
    }

    @GetMapping
    public List<RecoEntity> getRecoMsgList(){
        logger.info("getRecoMsgList()");
        return recoService.allRec();
    }

    @GetMapping("{productId}")
    public List<RecoEntity> getRecoMsgListOnProduct(@PathVariable ("productId") int productId){
        logger.info("getRecoMsgList() - on product ID {}",productId);
        return recoService.allProductRec(productId);
    }
    @PostMapping
    public String createRecoMsg(@RequestBody RecoEntity reco){
        logger.info("createRecoMsg()");
        return recoService.createRecom(reco);
    }

    @DeleteMapping("{recomsgId}")
    public void diactivetRecoMsg(@PathVariable ("recomsgId") int productId){
        logger.info("diactivetRecoMsg({})", productId);
        recoService.diactivetRecomByProdId(productId);
    }


}
