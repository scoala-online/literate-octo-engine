package org.scoalaonline.api.service;

import org.scoalaonline.api.exceptions.StockInvalidData;
import org.scoalaonline.api.exceptions.StockNotFoundException;
import org.scoalaonline.api.model.Stock;
import org.scoalaonline.api.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
  //injectez repo
  @Autowired
  StockRepo stockRepo;

  public Boolean exists (long id){
    return stockRepo.existsById(id);
  }
  public List<Stock> getAll (){
    List<Stock> listStock = stockRepo.findAll();
    return listStock;
  }
  // ----- Get Stock -----
  public Stock get (long id) throws StockNotFoundException {
    return stockRepo.findById(id).orElseThrow(() -> new StockNotFoundException("Stock not found."));
  }
  // ----- Add Stock -----
  public Stock add (Stock stock ) throws StockInvalidData {
    Stock stockToSave = new Stock();
    if(stock.getStockName() != null && !stock.getStockName().equals(""))
      stockToSave.setStockName(stock.getStockName());
    else
      throw new StockInvalidData("Invalid name.");
    if(stock.getTickerName() != null && stock.getTickerName().matches("^[$][A-Z]+[.]?[-]?[A-Z]+$"))
      stockToSave.setTickerName(stock.getTickerName());
    else
      throw new StockInvalidData("Invalid ticker.");
    if(stock.getStockPrice() > 0)
      stockToSave.setStockPrice(stock.getStockPrice());
    else
      throw new StockInvalidData("Invalid price.");
    if(stock.getStockMedianPrice() > 0)
      stockToSave.setStockMedianPrice(stock.getStockMedianPrice());
    else
      throw new StockInvalidData("Invalid median price.");

    return stockRepo.save(stockToSave);
  }
  // ----- Update Stock -----
  public Stock update(long id, Stock stock) throws StockNotFoundException, StockInvalidData {
    Stock stockToUpdate = stockRepo.findById(id).orElseThrow(() -> new StockNotFoundException("Stock not found."));

    if(stock.getStockName() != null && !stock.getStockName().equals("")) {
      stockToUpdate.setStockName(stock.getStockName());
    } else {
      throw new StockInvalidData("Invalid name.");
    }
    if(stock.getTickerName() != null && stock.getTickerName().matches("^[$][A-Z]+[.]?[-]?[A-Z]+$")) {
      stockToUpdate.setTickerName(stock.getTickerName());
    } else {
      throw new StockInvalidData("Invalid ticker.");
    }
    if(stock.getStockPrice() != null && stock.getStockPrice() > 0) {
      stockToUpdate.setStockPrice(stock.getStockPrice());
    } else {
      throw new StockInvalidData("Invalid price.");
    }
    if(stock.getStockMedianPrice() != null && stock.getStockMedianPrice() > 0){
      stockToUpdate.setStockMedianPrice(stock.getStockMedianPrice());
    } else {
      throw new StockInvalidData("Invalid median price.");
    }
    return stockRepo.save(stock);
  }
  // ----- Delete Stock -----
  public void delete (long id) throws StockNotFoundException{
    if(exists(id))
      stockRepo.deleteById(id);
    else
      throw new StockNotFoundException("Stock not found.");
  }
  public boolean stockExists (long id) {
    return stockRepo.existsById(id);
  }
}

