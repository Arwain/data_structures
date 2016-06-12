/*
 * The following class creates a Stack, essentially a Stack of Objects. A Stack is a data structure
 * that provides a LIFO(Last In First Out) list structure for data. The push method within this class
 * will take an Object as a parameter and place it in the first position in the list, while the pop method
 * will remove the first Object in the list. Stacks created within this class will double in
 * size automatically as is necessary for the data. 
 * 
 * @author Arwain Karlin 
 * last modified - 4/26/2016
 * 
 * Stack V1.0
 */
public class Stack {

	private Object[] array = new Object[1];// Initializes the instance Object
											// array.
	private int numElements = 0;// Initializes the instance counter variable.

	public Stack() { // This constructor is a default if the class is
						// called without parameters.
	}

	/*
	 * The following constructor takes an Object as a parameter and adds that
	 * Object to the array.
	 */
	public Stack(Object input) {
		push(input);
	}

	/*
	 * The constructor below takes a Stack as a parameter and loops through that
	 * Stack utilizing the push/pop methods to create an identical Stack. It is
	 * essentially a copy constructor.
	 */
	public Stack(Stack input) {
		int loopTemp = input.size();
		for (int index = 0; index < loopTemp; index++) {
			push(input.stackCopyGet(index));
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
	public void push(Object input) {
		if (numElements == array.length) {
			doubleInSize();
		}
		array[numElements++] = input;
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
	 * The following method returns the numElements variable, in other words,
	 * the size of the array is returned.
	 */
	public int size() {
		return numElements;
	}

	/*
	 * The following method returns the first Object within the array.
	 */
	public Object pop() {
		return array[--numElements];
	}

	/*
	 * This is a private method designed to only be used within the copy
	 * constructor as it violates the parameters of the data structure. This
	 * method returns the Object at any given index it is essentially a getter.
	 */
	private Object stackCopyGet(int index) {
		return array[index];
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

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Stack)) {
			throw new RuntimeException("Object is not a Stack!");
		} else {
			boolean areEqual = false;
			Stack that = new Stack((Stack) o);// Here is were it flips.
			if (this.size() != that.size()) {
				// System.out.println("Here@1");
				// System.out.println(that.size());
				// System.out.println(this.size());
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
