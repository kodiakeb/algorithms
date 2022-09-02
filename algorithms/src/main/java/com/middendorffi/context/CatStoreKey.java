package com.middendorffi.context;

/**
 * Created by hdavis on 20/02/2019.
 */
public class CatStoreKey extends StoreKey<CatStoreItem> {
    public CatStoreKey() {
        this.name = "CAT";
        this.dataClass =  CatStoreItem.class;
    }
}
