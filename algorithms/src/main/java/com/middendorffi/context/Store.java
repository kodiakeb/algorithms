package com.middendorffi.context;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by hdavis on 20/02/2019.
 */
public class Store {
    public Map<StoreKey,StoreItem> map = Maps.newHashMap();

    public boolean put(StoreKey storeKey,StoreItem storeItem) {
        if (storeKey.dataClass.equals(storeItem.getClass())) {
            map.put(storeKey,storeItem);
            return true;
        }
        return false;
    }

    public StoreItem get(StoreKey storeKey) {
        return map.get(storeKey);

    }
}
