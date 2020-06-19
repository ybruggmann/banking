/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.test;

public class Stock {

  private final String stockId;

  private final String name;

  private final int quantity;

  public Stock(String stockId, String name, int quantity) {
    this.stockId = stockId;
    this.name = name;
    this.quantity = quantity;
  }

  public String getStockId() {
    return stockId;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }
}