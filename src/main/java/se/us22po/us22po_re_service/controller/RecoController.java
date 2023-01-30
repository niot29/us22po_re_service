package se.us22po.us22po_re_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;
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
        logger.info("info()");
        return "The application (RecommendationService) is up ..";
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
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createRecoMsg(@RequestBody RecoEntity reco){
        logger.info("createRecoMsg()");
        Boolean status = recoService.createRecom(reco);
        if(status == false){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Rating is to large (CODE 406)\n");
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body("Information is save Code (CODE 201)\n");
        }
    }

    @DeleteMapping("{productId}")
    public void diactivetRecoMsg(@PathVariable ("productId") int productId){
        logger.info("diactivetRecoMsg({})", productId);
        recoService.diactivetRecomByProdId(productId);
    }



}
