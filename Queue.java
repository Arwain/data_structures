/*
 * The following class creates a Queue, essentially a queue of Objects. A queue is a data structure
 * that provides a FIFO(First In First Out) list structure for data. The enqueue method within this class
 * will take an Object as a parameter and place it in the last position in the list, while the dequeue method
 * will remove the first Object in the list. Queues created within this class will double in
 * size automatically as is necessary for the data. 
 * 
 * @author Arwain Karlin 
 * last modified - 4/26/2016
 * 
 * Queue V1.0
 */
public class Queue {
	private Object[] array = new Object[1];// Initializes the instance Object
											// array.
	private int numElements = 0;// Initializes the instance counter variable.

	public Queue() { // This constructor is a default if the class is
						// called without parameters.
	}

	/*
	 * The constructor below takes a Queue as a parameter and loops through that
	 * Queue utilizing the enqueue/dequeue methods to create an identical Queue.
	 * It is essentially a copy constructor.
	 */
	public Queue(Queue input) {
		int loopTemp = input.size();
		for (int index = 0; index < loopTemp; index++) {
			enqueue(input.dequeue());// Nested method call.
		}
	}

	/*
	 * The following constructor takes an Object as a parameter and adds that
	 * Object to the array.
	 */
	public Queue(Object input) {
		enqueue(input);// Nested method call.
	}

	/*
	 * The following method can be used to add Objects to the array. This method
	 * also enables the array to double in size for storage of additional
	 * objects as needed. A conditional is utilized to check if the current
	 * array is full of Objects and doubles the array if it is full. The input
	 * Object is then added to the array and the numElements counter incremented
	 * by 1.
	 */
	public void enqueue(Object input) {
		if (numElements == array.length) {
			doubleInSize();// Nested method call.
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
	 * The following method removes the first Object from the array then
	 * utilizes the shift left method to rearrange the remaining data within the
	 * array.
	 */
	public Object dequeue() {
		if (isEmpty()) {// Nested method call.
			throw new RuntimeException("The Queue is empty.");
		}
		Object temp = array[0];
		array[0] = null;
		arrayShiftLeft();// Nested method call.
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
	 * The following method overrides the java.lang equals method. This method
	 * takes an Object as a parameter, then uses a conditional to determine if
	 * the Object is an Queue. If so the Object is used to create a new Queue
	 * that is then checked for equivalence against the current Queue. A boolean
	 * is returned with the end result of the multi-way conditional.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Queue)) {
			throw new RuntimeException("Object is not a Queue!");
		} else {
			boolean areEqual = false;
			Queue that = new Queue((Queue) o);
			if (this.size() != that.size()) {// Nested method call.
				return false;
			} else {

				if (this.toString().equals(that.toString())) {// Nested method
																// call.
					areEqual = true;
				} else {
					areEqual = false;
				}
			}
			return areEqual;
		}

	}

	/*
	 * The following private method shifts the array left by 1. A loop is
	 * utilized to do this. This method is a simple loop with array object
	 * overwrite.
	 */
	private void arrayShiftLeft() {
		for (int i = 1; i < array.length; i++) {
			array[i - 1] = array[i];
		}
	}

}
