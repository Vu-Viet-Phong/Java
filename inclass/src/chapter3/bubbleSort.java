package chapter3;

class ArrayBub {
	private long[] arr;
	private int nElems;

	public ArrayBub(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

	public void bubbleSort() {
		for (int out = nElems - 1; out > 1; out--) {
			for (int in = 0; in < out; in++) {
				if (arr[in] > arr[in + 1] ) {
					swap(in, in + 1);
                }
            }
        }
	}
	
	public void biDirectionBubbleSort() {
		int out = nElems-1, in, _out = 0;
		
		boolean isSwap = true;
		
		while(isSwap) {
			isSwap = false;
			
			for(in=_out; in<out; in++) {
				if( arr[in] > arr[in+1] ) {
					swap(in, in+1);
					isSwap=true;
				}
			}
			
			for(in=out-1; in>_out; in--) {
				if(arr[in] < arr[in-1]) {
					swap(in, in-1);
					isSwap=true;
				}
			}
			
			_out++;
			out--;
		}
			
	}
	
	public void oddEvenSort() {
		boolean isSwap=true;
		
		while(isSwap) {
			isSwap = false;
			
			for(int in=1; in<nElems-1; in+=2) {
				if( arr[in] > arr[in+1] ) {
					swap(in, in+1);
					isSwap=true;
				}
			}
			
			for(int in=0; in<nElems-1; in+=2) {
				if( arr[in] > arr[in+1] ) {
					swap(in, in+1);
					isSwap=true;
				}
			}
			
		}
		
	}

	private void swap(int one, int two) {
		long temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}

    public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
        }

		System.out.println("");
	}
}

class bubbleSort {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayBub arr = new ArrayBub(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.bubbleSort();
		arr.display();

		// arr.oddEvenSort();
		// arr.display();
	}
}
