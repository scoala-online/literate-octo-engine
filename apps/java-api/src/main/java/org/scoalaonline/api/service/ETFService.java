package org.scoalaonline.api.service;

import org.scoalaonline.api.model.ETF;
import org.scoalaonline.api.repo.ETFRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETFService {
  //injectez repo
  @Autowired
  ETFRepo etfRepo;

  public Boolean ETFExists (long id){
    return etfRepo.existsById(id);
  }
  public List<ETF> allETF (){
    List<ETF> listEtf = etfRepo.findAll();
    //let's take a break. :D
    return listEtf;
  }
  // delete etf
  // add etf
  // update etf
}

