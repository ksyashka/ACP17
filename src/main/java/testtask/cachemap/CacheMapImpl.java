package testtask.cachemap;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;


public class CacheMapImpl<KeyType, ValueType> implements CacheMap<KeyType, ValueType> {

    public static final int DEFAULT_TABLE_SIZE = 16;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    final float loadFactor = DEFAULT_LOAD_FACTOR;

    MyNode<KeyType, ValueType>[] table = new MyNode[DEFAULT_TABLE_SIZE];
    int size;

    long TimeToLive;

    public CacheMapImpl(long timeToLive) {
        TimeToLive = timeToLive;
    }

    @Override
    public void setTimeToLive(long timeToLive) {
        TimeToLive = timeToLive;
    }

    @Override
    public long getTimeToLive() {
        return TimeToLive;
    }

    @Override
    public ValueType put(KeyType key, ValueType value) {

        int position = getPosition(key);

        if (table[position] == null)
            table[position] = new MyNode<KeyType, ValueType>(key, value, null);
        else {
            MyNode<KeyType, ValueType> iter = table[position];
            do {
                if (iter.key.equals(key)) {
                    ValueType oldValue = iter.value;
                    iter.value = value;
                    return oldValue;
                }
            } while (iter.next != null);
            iter.next = new MyNode<KeyType, ValueType>(key, value, null);
        }
        size++;
        return null;
    }
//TODO method
    @Override
    public void clearExpired() {

    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (int i = 0; i < table.length; i++)
                table[i] = null;
            size = 0;
        }

    }

    @Override
    public boolean containsKey(Object key) {
        int position = getPosition(key);
        return table[position].key == key;
    }

    @Override
    public boolean containsValue(Object value) {
        if (!isEmpty()) {
            for (int i = 0; i < table.length; i++) {
                if(value.equals(table[i].value)) return true;
            }
        }
        return false;
    }

    @Override
    public ValueType get(Object key) {
        int position = getPosition(key);
        if (table[position]!=null) return table[position].value;
        return null;
    }

    private int getPosition(Object key) {
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }

    @Override
    public ValueType remove(Object key) {
        int position = getPosition(key);
        ValueType returnValue = table[position].value;
        table[position] = null;
        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int size() {
        return size;
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
