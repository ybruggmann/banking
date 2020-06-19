/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.test;

import java.util.List;

public class Portfolio {

  private final StockService stockService;

  private final List<Stock> stocks;

  public Portfolio(StockService stockService, List<Stock> stocks) {
    this.stockService = stockService;
    this.stocks = stocks;
  }

  public StockService getStockService() {
    return stockService;
  }

  public List<Stock> getStocks() {
    return stocks;
  }

  public double getMarketValue() {
    double marketValue = 0.0;
    for (Stock stock : stocks) {
      marketValue += stockService.getPrice(stock) * stock.getQuantity();
    }
    return marketValue;
  }
}