package org.scoalaonline.api.controller;

import org.scoalaonline.api.exceptions.StockInvalidData;
import org.scoalaonline.api.exceptions.StockNotFoundException;
import org.scoalaonline.api.model.ETF;
import org.scoalaonline.api.model.Stock;
import org.scoalaonline.api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = {"stocks/"})
public class StockController {

  @Autowired
  StockService stockService;

  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Stock>> getAllStocks () {
    List<Stock> stockList = stockService.getAll();
    return new ResponseEntity<>(stockList, HttpStatus.OK);
  }
  @GetMapping(value = {"/{id}"})
  public ResponseEntity<Stock> getStockById(@PathVariable("id") long id){
    Stock stock;
    try {
      stock = stockService.get(id);
    } catch (StockNotFoundException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,"GET: Stock not found.",e);
    }
    return new ResponseEntity<>(stock,HttpStatus.OK);
  }
  @PostMapping(value = {"","/"})
  public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
    Stock savedStock;
    try{
      savedStock = stockService.add(stock);
    } catch (StockInvalidData e) {
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"POST: Invalid stock.",e);
    }
    return new ResponseEntity<>(savedStock, HttpStatus.OK);
  }
  @PutMapping(value = {"/{id}"})
  public ResponseEntity<Stock> updateStock(@PathVariable("id") long id, @RequestBody Stock stock) {
    Stock updatedStock;
      try{
        updatedStock = stockService.update(id, stock);
      } catch (StockNotFoundException | StockInvalidData e) {
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"PUT: Invalid stock.", e);
      }
      return new ResponseEntity<>(updatedStock, HttpStatus.OK);
  }
  @DeleteMapping(value = {"/{id}"})
  public ResponseEntity<Stock> deleteStock(@PathVariable("id") long id) {
    try{
      stockService.delete(id);
    } catch (StockNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"DELETE: Invalid stock", e);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
