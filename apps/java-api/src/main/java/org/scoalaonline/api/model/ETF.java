package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etf")
public class ETF
{

  //--------------- Fields ---------------
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "etf_id")
  private long id;

  @Column(name = "etf_name", nullable = false, length = 50)
  private String name;

  @Column(name = "etf_ticker", nullable = false, length = 10)
  private String ticker;


  public ETF(){
  }
  //--------------- Getters ---------------
  public long getId(){
    return id;
  }

  public String getEtfName(){
    return name;
  }

  public String getEtfTicker(){
    return ticker;
  }

  //--------------- Setters ---------------
  public void setId(long id) {
    this.id = id;
  }

  public void setEtfName (String name){
    this.name = name;
  }
  public void setEtfTicker (String ticker){
    this.ticker = ticker;
  }

  //--------------- Equals & Hashcode ---------------
  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ETF etf = (ETF) o;
    return id == etf.id &&
      name.equals(etf.name) &&
      ticker.equals(etf.ticker);
  }
  @Override
  public int hashCode()
  {
    return Objects.hash(id, name, ticker);
  }
}
