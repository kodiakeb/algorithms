package com.middendorffi.context;

/**
 * Created by hdavis on 20/02/2019.
 */
public class BananaStoreItem extends StoreItem {
    private Banana banana;

    public BananaStoreItem(Banana banana) {
        this.banana = banana;
    }

    public Banana getBanana() {
        return banana;
    }
}
