package com.naresh.old.javapractice.companywise.adp;

import java.util.List;

public interface VendingMachine {

    public long selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();

    public int checkIfneedToreturnAmount(Integer actual_price, Integer received_value);
}
