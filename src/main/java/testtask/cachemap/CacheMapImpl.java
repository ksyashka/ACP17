package testtask.cachemap;

import java.util.Map;

public class CacheMapImpl<KeyType, ValueType> implements CacheMap<KeyType, ValueType> {

    public static final int DEFAULT_TABLE_SIZE = 16;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    final float loadFactor = DEFAULT_LOAD_FACTOR;

    MyNode<KeyType, ValueType>[] table = new MyNode[DEFAULT_TABLE_SIZE];
    int size;

    @Override
    public void setTimeToLive(long timeToLive) {

    }

    @Override
    public long getTimeToLive() {
        return 0;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public void clearExpired() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private static class MyNode<NK, NV> implements Map.Entry<NK, NV> {
        NK key;
        NV value;
        MyNode<NK, NV> next;

        public MyNode(NK key, NV value, MyNode<NK, NV> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public NK getKey() {
            return key;
        }

        @Override
        public NV getValue() {
            return value;
        }

        @Override
        public NV setValue(NV value) {
            NV old = this.value;
            this.value = value;
            return old;
        }
    }
}
