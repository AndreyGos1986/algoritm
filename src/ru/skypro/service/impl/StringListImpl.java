package ru.skypro.service.impl;

import ru.skypro.service.interfaces.StringList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringListImpl implements StringList {
    private  int size=0;
    private int capacity=10;
    private String [] list;
    private int index=0;

    public StringListImpl() {
        list = new String[capacity];
        for (int i = 0; i < list.length; i++) {
            list[i] = "";
        }
    }

    public StringListImpl(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            list = new String[this.capacity];
            for (int i = 0; i < list.length; i++) {
                list[i] = "";
            }
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }


    @Override
    public String add(String item) {
        checkItem (item);
        resizingList();
        list[size++]=item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        resizingList();
        System.arraycopy(list, index, list, index + 1, capacity - index - 1);
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
      checkItem(item);
      checkIndex(index);
      list [index]=item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        int index=indexOf(item);
        if (index>=0) {
            return  remove(index);
        } else {
            throw new NoSuchElementException("");
        }
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1);
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        checkItem(item);
        int index = indexOf(item);
        if (index!=-1) {
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)){
                return  i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
            checkItem(item);
            for (int i = list.length-1; i >=0 ; i--) {
                if (list[i].equals(item)){
                    return  i;
                }
            }
            return -1;
        }

    @Override
    public String get(int index) {
        checkIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException("");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!list[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = "";
            size = 0;
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }

    private void checkItem(String item) {
        if (item==null) {
            throw new NullPointerException("");
        }
    }
    private void checkIndex(int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("");
        }
    }
    private void resizingList() {
        if (size == capacity) {
            capacity *= 2;
            list = Arrays.copyOf(list, capacity);
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = "";
                }
            }
        }
    }
}
