package com.middendorffi.context;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by hdavis on 20/02/2019.
 */
public abstract class StoreKey<T extends StoreItem> {
    public String name;
    public Class<?> dataClass;

    public String getName() {
        return name;
    }

    public Class<?> getDataClass() {
        return dataClass;
    }

    public Optional<T> access(StoreItem storeItem) {
        if(storeItem != null && dataClass.equals(storeItem.getClass())) {
            return Optional.of((T) storeItem);
        }
        return Optional.empty();
    }

    public Optional<T> access(Store store) {
        if (store == null) {
            Optional.empty();
        }
        StoreItem storeItem = store.get(this);
        if(storeItem != null && dataClass.equals(storeItem.getClass())) {
            return Optional.of((T) storeItem);
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreKey)) return false;
        StoreKey storeKey = (StoreKey) o;
        return Objects.equals(name, storeKey.name) &&
                Objects.equals(dataClass, storeKey.dataClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataClass);
    }
}
