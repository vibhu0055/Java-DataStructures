/* Customized int type ArrayList implementation, with functions like 
 * add , remove , size ,
 */

import java.util.Arrays;

class Arraylist {
    public static void main(String[] args) {
        Arraylist a = new Arraylist();
        for (int i = 0; i < 12; i++) {
            a.add(i);
        }
        a.remove(5);
        System.out.println(a);

    }

    private int[] data;
    private int size = 0;
    private int defaults = 10;

    public Arraylist() {
        this.data = new int[defaults];
    }

    public void add(int num) {
        if (this.isfull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isfull() {
        return size == data.length;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int size() {
        return size;
    }

    public void remove(int num) {
        for (int i = 0; i < size; i++) {
            if (num == data[i]) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                break;
            }
        }
    }
    
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

}
