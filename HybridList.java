
import java.util.Arrays;

class HybridList<E> {
	KWLinkedList<KWArrayList<E>> furnitures;

	private int MAX_NUMBER = 30;
	private int size = 0;
	int capacity = 0;

	public HybridList() {
		furnitures = new KWLinkedList<KWArrayList<E>>();
		KWArrayList<E> temp = new KWArrayList();
		furnitures.add(temp);
	}
	
	public boolean add(E anEntry) {
		 if (size == MAX_NUMBER) {
			 capacity++;
			 size = 0;
		 }
		 furnitures.get(capacity).add(anEntry);
		 size++;
		 return true;
	}
	
	public void add(int index, E anEntry) {
		 if (index < 0 || index > size) {
			 throw new ArrayIndexOutOfBoundsException(index);
		 }
		 if (size == MAX_NUMBER) {
			 capacity++;
			 size = 0;
		 }
		 // Shift data in elements from index to size - 1
		 for (int i = size; i > index; i--) {
			 furnitures.get(capacity).add(i, furnitures.get(capacity).get(i-1));
		 }
		 // Insert the new item.
		 
		 furnitures.get(capacity).add(index, anEntry);
		 size++;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return furnitures.get(capacity).get(index);
	}
	
	public E set(int index, E newValue) {
		 if (index < 0 || index >= size) {
			 throw new ArrayIndexOutOfBoundsException(index);
		 }
		 E oldValue = furnitures.get(capacity).get(index);
		 furnitures.get(capacity).set(index, newValue);
		 return oldValue;
	}
	
	public E remove(int index) {
		 if (index < 0 || index >= size) {
			 throw new ArrayIndexOutOfBoundsException(index);
		 }
		 E returnValue = furnitures.get(capacity).get(index);
		 for (int i = index + 1; i < size; i++) {
			 furnitures.get(capacity).add(i-1, furnitures.get(capacity).get(i));
		 }
		 size--;
		 return returnValue;
	}
}
