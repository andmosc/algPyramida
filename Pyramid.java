package pyramid;

public class Pyramid extends DynamicArray {
    private DynamicArray data;

    public Pyramid() {
        data = new DynamicArray();
    }

    public int root() {
        return data.get(0);
    }

    public int fromIndex(int index) {
        return data.get(index);
    }

    public int leftIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    public int rightIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    public boolean noChild(int index) {
        return leftIndex(index) > getSize();
    }

    public int minChild(int parantIndex) {
        int l, r;
        int min;

        if (leftIndex(parantIndex) < data.getSize())
            l = leftIndex(parantIndex);
        else l = -1;
        if (rightIndex(parantIndex) < data.getSize())
            r = rightIndex(parantIndex);
        else r = -1;

        if (l != -1 && r != -1) {
            if (data.get(l) > data.get(r))
                min = r;
            else min = l;
        } else {
            if (l == -1)
                min = r;
            else
                min = l;
        }
        return min;
    }

    public int parentIndex(int childIndex) {
        return Math.round((childIndex - 1) / 2);
    }

    public void add(int element) {
        data.append(element);
        tryUp(getSize() - 1);
    }

    private void tryUp(int index) {
        if (index == 0) {
            return;
        }
        int parIndex = parentIndex(index);
        if (data.get(parIndex) > data.get(index)) {
            swap(index, parIndex);
        }
        tryUp(parIndex);
    }

    private void swap(int index, int parantIndex) {
        int a = data.get(index);
        int b = data.get(parantIndex);

        data.set(index, b);
        data.set(parantIndex, a);
    }

    public void siftDown(int index) {

        if (noChild(index))
            return;

        int minChild = minChild(index);

        if (data.get(index) > data.get(minChild)) {
            swap(index, minChild);
        }
        siftDown(minChild);
    }

    public int extractMin() {
        int min = data.get(0);
        data.set(0, get(getSize() - 1));
        data.removeEnd();
        siftDown(0);
        return min;
    }
}