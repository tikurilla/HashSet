import java.util.*;

public class HashSet<T> implements Set<T> {

    private static final Boolean EXIST = true;

    private final Map<T, Boolean> elements = new HashMap<>();
    // Have to complete:
    // <T1> T1[] toArray(T1[] a)
    // removeAll(Collection<?> c)
    // retainAll(Collection<?> c)
    // clear()

    @Override
    public int size() {
        // BEGIN (write your solution here)
        return elements.size();
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return elements.size() == 0;
        // END
    }

    @Override
    public boolean contains(Object o) {
        // BEGIN (write your solution here)
        return elements.containsKey(o);
        // END
    }

    @Override
    // created 21.07.2017 22.35
    // modified 03.08.20017 09.23
    public Iterator<T> iterator() {
        // BEGIN (write your solution here)
        return new Iterator<T>() {

            private static final int LAST_IS_NOT_SET = -1;
            private int index;
            private int lastIndex = LAST_IS_NOT_SET;

            @Override
            public boolean hasNext() {
                return HashSet.this.size() > index;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                lastIndex = index;
                Object[] SetArray = new Object[HashSet.this.size()];
                SetArray = HashSet.this.toArray();
                return (T)SetArray[index++];
            }
        };
        // END
    }

    private class ElementsIterator<T> implements Iterator<T> {
        private static final int LAST_IS_NOT_SET = -1;
        private int index;
        private int lastIndex = LAST_IS_NOT_SET;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            this.index = index;
            // END
        }

        @Override
        public boolean hasNext() {
            return HashSet.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastIndex = index;
            Object[] SetArray = new Object[HashSet.this.size()];
            SetArray = HashSet.this.toArray();
            return (T)SetArray[index++];
        }
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        return elements.keySet().toArray();
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        return null;
        // END
    }

    @Override
    // 21.07.2017 22.50
    public boolean add(T t) {
        // BEGIN (write your solution here)
        if (elements.containsKey(t)) {
            return false;
        }
        elements.put(t, EXIST);
        return true;
        // END
    }

    @Override
    // 21.07.2017 22.52
    public boolean remove(Object o) {
        // BEGIN (write your solution here)
        if (elements.containsKey(o)) {
            elements.remove(o);
            return true;
        }
        return false;
        // END
    }

    @Override
    // 03.08.2017 09.53
    public boolean containsAll(Collection<?> c) {
        // BEGIN (write your solution here)
        if (c.size() == 0)
            return false;
        for(Object item : c) {
            if(!this.contains(item))
                return false;
        }
        return true;
        // END
    }

    @Override
    // 21.07.2017 23.34
    public boolean addAll(Collection<? extends T> c) {
        // BEGIN (write your solution here)
        final Map<T, Boolean> cSet = collectionToHashSet(c);
        if (c.size()==cSet.size()) {
            elements.putAll(cSet);
            return true;
        }
        return false;
        // END
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // BEGIN (write your solution here)
        return false;
        // END
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // BEGIN (write your solution here)
        return false;
        // END
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        // END
    }

    private Map<T, Boolean> collectionToHashSet(Collection<? extends T> c) {
        final Map<T, Boolean> cSet = new HashMap<>();
        Object[] cArray = new Object[c.size()];
        cArray = c.toArray();
        for(int i=0;i<c.size();i++){
            cSet.put((T)cArray[i], EXIST);
        }
        return cSet;
    }
}
