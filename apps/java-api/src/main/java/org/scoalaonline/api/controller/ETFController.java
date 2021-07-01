package org.scoalaonline.api.controller;

import org.scoalaonline.api.exceptions.ETFInvalidData;
import org.scoalaonline.api.exceptions.ETFNotFoundException;
import org.scoalaonline.api.model.ETF;
import org.scoalaonline.api.service.ETFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/etfs")
public class ETFController {

  @Autowired
  ETFService etfService;

  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<ETF>> getAllETFs () {
    List<ETF> etfList = etfService.getAll();
    return new ResponseEntity<>(etfList, HttpStatus.OK);
  }
  @GetMapping(value = "/{id}")
  public ResponseEntity<ETF> getEtfById(@PathVariable("id") long id) {
    ETF etf;
    try
    {
      etf = etfService.get( id );
    } catch ( ETFNotFoundException e )
    {
      throw new ResponseStatusException( HttpStatus.NOT_FOUND, "GET: ETF Not Found", e );
    }

    return new ResponseEntity<>( etf, HttpStatus.OK );
  }
  @PostMapping(value = {"", "/"})
  public ResponseEntity<ETF> addETF(@RequestBody ETF etf){
    ETF savedETF;
    try {
      savedETF = etfService.add(etf);
    } catch (ETFInvalidData e){
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"POST: Invalid Data", e);
    }
      return new ResponseEntity<>(savedETF, HttpStatus.OK);
  }
  @PutMapping(value = {"/{id}"})
  public ResponseEntity<ETF> updateETF(@PathVariable("id") long id, @RequestBody ETF etf){
    ETF updatedETF;
    try {
      updatedETF = etfService.update(id,etf);
    } catch (ETFInvalidData | ETFNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "PUT: Invalid Data", e);
    }
    return new ResponseEntity<>(updatedETF, HttpStatus.OK);
  }
  @DeleteMapping(value = {"/{id}"})
  public ResponseEntity<ETF> deleteETF(@PathVariable("id") long id) {
    try {
      etfService.delete(id);
    } catch (ETFNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "DELETE: Data not found.", e);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
