package com.middendorffi.context;

/**
 * Created by hdavis on 20/02/2019.
 */
public class CatStoreItem extends StoreItem {
    private Cat cat;

    public CatStoreItem(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }
}
