package com.middendorffi.context;

import java.util.Optional;

/**
 * Created by hdavis on 20/02/2019.
 */
public class StoreHarness {
    public static void main(String[] args) {
        System.out.println("HARNESS");

        Store store = new Store();


        Cat kitten = new Cat();
        CatStoreItem kittenStoreItem = new CatStoreItem(kitten);

        Banana minion = new Banana();
        BananaStoreItem minionStoreItem = new BananaStoreItem(minion);

        CatStoreKey catStoreKey = new CatStoreKey();
        boolean catPut = store.put(catStoreKey,kittenStoreItem);
        BananaStoreKey bananaStoreKey = new BananaStoreKey();
        boolean bananaPut = store.put(bananaStoreKey,minionStoreItem);
        RockStoreKey rockStoreKey = new RockStoreKey();
        boolean rockPut = store.put(rockStoreKey,kittenStoreItem); // expect fail

        Optional<CatStoreItem> foundCat2 = catStoreKey.access(store);
        Cat endCat = foundCat2.isPresent()? foundCat2.get().getCat():null;

        Optional<BananaStoreItem> foundBanana2 = bananaStoreKey.access(store);
        Banana endBanana = foundBanana2.isPresent()? foundBanana2.get().getBanana():null;

        Optional<RockStoreItem> foundRock2 = rockStoreKey.access(store);
        boolean rockPresent = foundRock2.isPresent();
    }
}
