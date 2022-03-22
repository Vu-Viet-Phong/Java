package tung.lab02;

import java.util.Random;

public class Array {
    private long[] arr;              
    private int nElems;
    private int maxElems;

	public Array(int maxElems) {
		this.maxElems = maxElems;
		arr = new long[maxElems];
	}

    public int getnElems() {
		return nElems;
	}

	public long[] getA() {
		return arr;
	}

    public void randomInit(int numElements) { 
        Random aRandom = new Random();
        nElems = numElements;

        for (int i = 0 ; i < nElems ; i++) {
            arr[i] = aRandom.nextLong() % 100000000;
        }
    }

    public void inverse() {
        long[] inver = new long[maxElems];

        for (int i = 0; i < nElems; i++) {
            inver[i] = arr[nElems-i-1];
        }
        
        arr = inver;
    }

    public void bubbleSort() {
        for (int out = nElems - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if(arr[in] > arr[in + 1] ) {
                    swap(in, in + 1);
                }
            }
        }
    }

    public void selectionSort() {
        int min;

        for(int out = 0; out < nElems - 1; out++) {
            min = out;      

            for (int in = out + 1; in < nElems; in++) { 
                if (arr[in] < arr[min] ) {        
                    min = in; 
                }
            }
            
            swap(out, min);
        } 
    } 

    private void swap(int one, int two) {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public void insertionSort() {
        for (int out=1; out<nElems; out++) {
            long temp = arr[out];            
            int in = out;

            while(in > 0 && arr[in-1] >= temp)  {
                arr[in] = arr[in-1];            
                --in;                       
            }

            arr[in] = temp;
        } 
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }

    public Array clone() {
		Array clone = new Array(this.maxElems);
		
        clone.nElems = this.nElems;
        for (int i = 0; i < nElems; i++) {
			clone.arr[i] = this.arr[i];
        }

		return clone;
	}
}