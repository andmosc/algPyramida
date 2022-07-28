package pyramid;

public class DynamicArray {
    private static final int DEFAULT_SIZE = 3;

    //private int index = 0;
    private static int lastIndex = 0;
    private int newSize = 0;
    private static int[] array;
    private int[] newArray;

    public DynamicArray() {
        array = new int[DEFAULT_SIZE];
        newSize = DEFAULT_SIZE;
    }

    public void append(int element) {

        if (lastIndex == newSize) {
            newSize += newSize;
            newArray = new int[newSize];
            for (int i = 0; i < lastIndex; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[lastIndex] = element;
        lastIndex++;
    }

    public void removeEnd() {
        if (lastIndex - 1 <= (newSize) / 2) {
            newArray = new int[lastIndex];
            for (int i = 0; i < lastIndex - 1; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            newSize = lastIndex;
            lastIndex--;
        } else {
            remove(lastIndex);
        }
    }

    public void insert(int index,int element) {
        if (lastIndex == newSize) {
            newSize += newSize;
            newArray = new int[newSize];
            for (int i = 0; i < lastIndex; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        for (int i = lastIndex; i > index-1; i--) {

            array[i] = array[i-1];
        }
        array[index-1] = element;
        lastIndex++;
    }

    public void set(int index,int element) {
        array[index] = element;
    }

    public int getMin() {
        int index = 0;
        for (int i = 0; i < getSize()-1; i++) {
            if (get(index) > get(i+1)) {
                index = i+1;
            }
        }
        return index;
    }

    public void remove(int index) {
        for (int i = index-1; i < lastIndex-1; i++) {
            array[i] = array[i + 1];
        }

        if (lastIndex - 1 <= (newSize) / 2) {
            newArray = new int[lastIndex];
            for (int i = 0; i < lastIndex - 1; i++) {
                newArray[i] = array[i];
            }
            newSize = lastIndex;
            lastIndex--;
            array = newArray;
        } else {
            lastIndex--;
        }
    }

    public int get(int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за диапазон массива");
        }
        return -1;
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return lastIndex;
    }

    @Override
    public String toString() {
        StringBuilder arr = new StringBuilder();
        for (int i = 0; i < lastIndex; i++) {
            arr.append(array[i]);
            if (i != lastIndex - 1) arr.append(",");
        }
        return arr.toString();
    }
}
