package com.middendorffi.context;

/**
 * Created by hdavis on 20/02/2019.
 */
public class RockStoreKey extends StoreKey<RockStoreItem> {
    public RockStoreKey() {
        this.name = "ROCK";
        this.dataClass =  RockStoreItem.class;
    }
}
