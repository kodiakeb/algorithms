package com.middendorffi.context;

/**
 * Created by hdavis on 20/02/2019.
 */
public class BananaStoreKey extends StoreKey<BananaStoreItem> {
    protected BananaStoreKey() {
        this.name = "BANANA";
        this.dataClass = BananaStoreItem.class;
    }
}
