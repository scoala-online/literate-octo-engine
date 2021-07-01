package org.scoalaonline.api.service;

import org.scoalaonline.api.exceptions.ETFInvalidData;
import org.scoalaonline.api.exceptions.ETFNotFoundException;
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

  public Boolean exists (long id){
    return etfRepo.existsById(id);
  }
  public List<ETF> getAll (){
    List<ETF> listEtf = etfRepo.findAll();
    return listEtf;
  }
  // ----- Get ETF -----
  public ETF get (long id) throws ETFNotFoundException {
    return etfRepo.findById(id).orElseThrow(() -> new ETFNotFoundException("Requested ETF not found."));
  }
  // ----- Add ETF -----
  public ETF add (ETF etf) throws ETFInvalidData {
    ETF etfToSave = new ETF();
    if(!etf.getEtfName().equals("") && etf.getEtfName() != null)
      etfToSave.setEtfName(etf.getEtfName());
    else
      throw new ETFInvalidData("Not a valid name.");
    if(etf.getEtfTicker() != null && etf.getEtfTicker().matches("^[A-Z]+:[A-Z]+$"))
      etfToSave.setEtfTicker(etf.getEtfTicker());
    else
      throw new ETFInvalidData("Not a valid ticker name.");

    return etfRepo.save(etfToSave);
  }
  // ----- Update ETF -----
  public ETF update (long id, ETF etf) throws ETFNotFoundException, ETFInvalidData {
    ETF etfToUpdate = etfRepo.findById(id).orElseThrow(() -> new ETFNotFoundException("Etf not found."));
    if(etf.getEtfName() != null && !etf.getEtfName().equals("")) {
      etfToUpdate.setEtfName(etf.getEtfName());
    } else {
      throw new ETFInvalidData("Not a valid name.");
    }
    if(etf.getEtfTicker() != null && etf.getEtfTicker().matches("^[A-Z]+:[A-Z]+$")) {
      etfToUpdate.setEtfTicker(etf.getEtfTicker());
    } else {
      throw new ETFInvalidData("Not a valid ticker name.");
    }
    return etfRepo.save(etfToUpdate);
  }
  // ----- Delete ETF -----
  public void delete (long id) throws ETFNotFoundException{
    if(exists(id))
      etfRepo.deleteById(id);
    else
      throw new ETFNotFoundException("The element you want to remove doesn't exist.");
  }
}

