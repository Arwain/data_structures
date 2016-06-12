/*
 * The following class creates an ArrayList, essentially a list of Objects. Methods 
 * exist within this class to modify, search, determine the size of, send to a String and
 * remove Objects within the list itself. ArrayLists created within this class will double in
 * size automatically as is necessary for the data. There are 3 constructors within the class 
 * for creating new lists with different parameters, one is empty (no parameters), one will take 
 * Objects along with their respective index and a final copy constructor that takes another ArrayList
 * as a parameter.  
 * 
 * @author Arwain Karlin
 * last modified - 4/26/2016
 * 
 * ArrayList V1.0
 */
public class ArrayList {
	private Object[] array = new Object[10];// Initializes the instance Object
	// array.
	private int numElements = 0;// Initializes the instance counter variable.

	public ArrayList() { // This constructor is a default if the class is
		// called without parameters.
	}

	/*
	 * The following constructor takes an Object as a parameter and adds that
	 * Object to the array.
	 */
	public ArrayList(Object input, int index) {
		insert(input, index);// Nested method call.
	}

	/*
	 * The following constructor takes an ArrayList as a parameter and creates a
	 * new ArrayList.
	 */
	public ArrayList(ArrayList input) {
		int size = input.size();
		for (int index = 0; index < size; index++) {
			insert(input.peek(index), index);// Nested method call.
		}
	}

	/*
	 * The following method can be used to add Objects to the array. This method
	 * also enables the array to double in size for storage of additional
	 * objects as needed. A conditional is utilized to check if the current
	 * array is full of Objects and doubles the array if it is full. The input
	 * Object is then added to the array and the numElements counter incremented
	 * by 1.
	 */
	public void insert(Object input, int index) {
		if (numElements > array.length - 2) {
			doubleInSize();// Nested method call.
		}
		Object temp = array[index];
		array[index] = input;
		numElements++;
		if (index < numElements) {
			arrayShiftRight(index);// Nested method call.
			array[index + 1] = temp;
		} else {
			array[index + 1] = temp;
		}
	}

	/*
	 * The following method can be used to add Objects to the array. This method
	 * also enables the array to double in size for storage of additional
	 * objects as needed. A conditional is utilized to check if the current
	 * array is full of Objects and doubles the array if it is full. The input
	 * Object is then added to the array and the numElements counter incremented
	 * by 1.Note: Below is essentially an identical method to the method above
	 * this method was added to meet the parameters of the contract, while above
	 * meets the parameters of the Driver.
	 */
	public void add(Object input, int index) {
		if (numElements > array.length - 2) {
			doubleInSize();// Nested method call.
		}
		Object temp = array[index];
		array[index] = input;
		numElements++;
		if (index < numElements) {
			arrayShiftRight(index);// Nested method call.
			array[index + 1] = temp;
		} else {
			array[index + 1] = temp;
		}
	}

	/*
	 * Below is an overloaded version of the insert method above that takes
	 * chars as input. This method is otherwise identical to the one above with
	 * the exception of the parameter argument.
	 */
	public void insert(char input, int index) {
		if (numElements > array.length - 2) {
			doubleInSize();// Nested method call.
		}
		Object temp = array[index];
		array[index] = input;
		numElements++;
		if (index < numElements) {
			arrayShiftRight(index);// Nested method call.
			array[index + 1] = temp;
		} else {
			array[index + 1] = temp;
		}
	}

	/*
	 * The following method checks if the list is empty by returning a boolean
	 * which returns true only if the number of elements remaining in the list
	 * is equal to zero.
	 */
	public boolean isEmpty() {
		return numElements == 0;
	}

	/*
	 * The following method takes an Object as a parameter and returns the index
	 * of that Object. A standard conditional within a loop structure is
	 * utilized to determine the index.
	 */
	public int indexOf(Object o) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == o) {
				return index;
			}
		}
		return -1;
	}

	/*
	 * The following method was designed originally to be used by the copy
	 * constructor, however, it has been altered to protect against privacy
	 * leaks and made public for use outside the class. It operates identical to
	 * a standard Stack peek and allows the user to view an Object at a given
	 * index.
	 */
	public Object peek(int index) {
		Object temp = array[index];
		return temp;
	}

	/*
	 * The following method returns the numElements variable, in other words,
	 * the size of the array is returned.
	 */
	public int size() {
		return numElements;
	}

	/*
	 * The following method removes an Object from the array then will adjust
	 * the array accordingly. A temporary Object is created and the
	 * arrayShiftLeft method is utilized to do this.
	 */
	public Object remove(int index) {
		if (isEmpty()) {// Nested method call.
			throw new RuntimeException("The ArrayList is empty.");
		}
		Object temp = array[index];
		array[index] = null;
		arrayShiftLeft(index);// Nested method call.
		numElements--;
		return temp;
	}

	/*
	 * The following method enables the array to double in size for storage of
	 * additional objects as needed. A loop is utilized to pass the Objects of
	 * the current array to a temporary array of double size. The original array
	 * is then set to the temporary array. Reference: Algorithm provided by Rob
	 * Nash.
	 */
	private void doubleInSize() {
		Object[] temp = new Object[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	/*
	 * The following method is an override of the toString method that exists
	 * within 'java.lang'. This toString returns a String consisting of each
	 * Object separated by a comma. A standard conditional within a loop
	 * structure is utilized to carry out this task. substring is utilized to
	 * fix fence-post.
	 */
	@Override
	public String toString() {
		String retVal = "";
		for (int i = 0; i < numElements; i++) {
			retVal += array[i] + ",";
		}
		return retVal.substring(0, retVal.length() - 1);
	}

	/*
	 * The following private method shifts the array right by 1. A reverse loop
	 * is utilized to do this. This method also contains a nested method call to
	 * the doubleInSize if a conditional is met.
	 */
	private void arrayShiftRight(int index) {
		if (numElements > array.length - 4) {
			doubleInSize();// Nested method call.
		}
		for (int i = array.length - 3; i > index; i--) {
			array[i + 1] = array[i];
		}
	}

	/*
	 * The following private method shifts the array left by 1. A loop is
	 * utilized to do this. This method is a simple loop with array object
	 * overwrite.
	 */
	private void arrayShiftLeft(int index) {
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
	}

	/*
	 * The following method overrides the java.lang equals method. This method
	 * takes an Object as a parameter, then uses a conditional to determine if
	 * the Object is an ArrayList. If so the Object is used to create a new
	 * ArrayList that is then checked for equivalence against the current
	 * ArrayList. A boolean is returned with the end result of the multi-way
	 * conditional.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof ArrayList)) {
			throw new RuntimeException("Object is not an ArrayList!");
		} else {
			boolean areEqual = false;
			ArrayList that = new ArrayList((ArrayList) o);// New Object created
															// here
			if (this.size() != that.size()) {
				// System.out.println("Here@1");
				// System.out.println(that.size());
				// System.out.println(this.size());
				// System.out.println(that.toString());
				// System.out.println(this.toString());

				return false;

			} else {
				if (this.toString().equals(that.toString())) {
					areEqual = true;
				} else {
					// System.out.println("Here@2");
					// System.out.println(this.toString());
					// System.out.println(that.toString());
					areEqual = false;
				}
			}
			// System.out.println("Here@3");
			return areEqual;
		}

	}

}
