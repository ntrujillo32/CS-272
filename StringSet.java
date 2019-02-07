/*Nicholas Trujillo
 * Febuary 7, 2019
 * CS 272- Lab2
 * 
 */



public class StringSet {

	private int ArraySize;
	private int Capacity; 
	private String[] data = new String[Capacity]; 
	
	public StringSet() {
		
		Capacity = 2; 
		data = new String[Capacity];
	}
	
	public StringSet(int _Capacity) {
		
		Capacity = _Capacity;
		data = new String[Capacity];
		
	}
	
	public StringSet(Object obj) {
		
		if( obj != null){
			if(obj instanceof StringSet) {
				StringSet objStringSet = (StringSet)obj;
				ArraySize = objStringSet.ArraySize;
				Capacity = objStringSet.Capacity;
				data = objStringSet.data;
				for(int i = 0; i < ArraySize; i++) 
						data[i] = objStringSet.data[i]; 
			}// if instance of
		}// if not null
	}// of copy constructor
	
	public int ArraySize() {
		return ArraySize;
	}
	
	public int Capacity() {
		return Capacity;
	}
	
	public void add(String a) {
		if(a != null) {
			if(Capacity == ArraySize) {
				Capacity = data.length *2;
				String[] newArr = new String [Capacity];
				System.arraycopy(data, 0, newArr, 0, ArraySize);
				data = newArr;
				data[ArraySize] = a;
				ArraySize++;
			}else{
				data[ArraySize] = a;
				ArraySize++;
			}
		}
	}
	public boolean contains(String a){
		if(a != null) {	
			for(int i = 0; i < ArraySize; i++) {
				if(data[i].equals(a)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean remove(String a) {
		if(a != null) {	
			for(int i = 0; i < ArraySize; i++) {
				if(data[i].equals(a)) {
					data[i] = data[ArraySize - 1];
					ArraySize--;
					return true;
				}
			}
		}
		return false;
	}

	private void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity > 0) {
			if(Capacity < minimumCapacity) {
				Capacity = minimumCapacity;
				String[] newArr = new String [Capacity];
				System.arraycopy(data, 0, newArr, 0, ArraySize);
				data = newArr;
			}
		}
	}
	
	public void addOrdered(String a) {
		
		
		if(a != null) {
			if(Capacity == ArraySize) {
				Capacity = data.length *2;
				String[] newArr = new String [Capacity];
				System.arraycopy(data, 0, newArr, 0, ArraySize);
				data = newArr;
				data[ArraySize] = a;
				ArraySize++;
			}else{
				data[ArraySize] = a;
				ArraySize++;
			}
		}
		
		
				
			}
		
		

		
	
	public static void main(String[] args) {
		
		StringSet s1 = new StringSet(); 
		StringSet s2 = new StringSet(3); 
		
		
		s1.add("Nicholas");
		s1.add("Gabby");
		s1.add("Paul");
		s1.add("Debra");
		
		System.out.println("ArraySize of String 1: " + s1.ArraySize());
		System.out.println("Capacity of String 1: " + s1.Capacity());
		System.out.println("String1: ");
		for(int i = 0; i < s1.ArraySize; i++) {
			System.out.println(s1.data[i]);
		}
		System.out.println("Does S1 contain Nate: " + s1.contains("Nate"));
		System.out.println("Does S1 contain Nicholas: " + s1.contains("Nicholas"));
		
		System.out.println();
		
		s2.add("Eric ");
		s2.add("Ryan");
		s2.add("Ty");
		
		System.out.println("ArraySize of String 2: " + s2.ArraySize());
		System.out.println("Capacity of String2: " + s2.Capacity());
		System.out.println("String2: ");
		for(int i = 0; i < s2.ArraySize; i++) {
			System.out.println(s2.data[i]);
		}
		System.out.println("If there is Nathan in S2 remove: " + s2.remove("Nathan"));
		System.out.println("If there is Sikta in S2 remove: " + s2.remove("Sikta"));
		for(int i = 0; i < s2.ArraySize; i++) {
			System.out.println(s2.data[i]);
		}
		
		System.out.println();
		StringSet copy_s1 = new StringSet(s1);
		
		System.out.println("ArraySize of copy1: " + copy_s1.ArraySize());
		System.out.println("Capacity of copy1: " + copy_s1.Capacity());
		System.out.println("copy1: ");
		for(int i = 0; i < copy_s1.ArraySize; i++) {
			System.out.println(copy_s1.data[i]);
		}
	}
}// of StringSet class






