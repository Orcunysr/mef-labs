package Week4;
// A generic queue that uses an array circularly to store the elements.
class MyQueue<E> {
   // data fields
   private E[] data; // a generic array for storing the elements in the queue
   private int size = 0; // the number of the stored elements (initially 0)
   private int first = 0; // the index of the first queue element (initially 0)

   // constructor that creates an empty queue with the specified initial capacity
   public MyQueue(int capacity) {
      // the array is created with the type Object instead of the generic type E
      // then casted to E[] as generic array creation is not possible
      data = (E[]) new Object[capacity];
   }

   // returns true if the queue is empty and false otherwise
   public boolean isEmpty() {
      return size == 0;
   }

   // returns the element at the start (head) of the queue without removing it
   public E peek() {
      // return null if the queue is empty
      if (isEmpty())
         return null;
      // return the element at index first (the element at the head of the queue)
      return data[first];
   }

   public E dequeue() {
       if (isEmpty())
           return null;
       E head = data[first];
       data[first] = null;
       first = (first + 1) % data.length;
       size--;
       return head;
   }



    public void enqueue(E e) {
        ensureCapacity();

        int rear = (first + size) % data.length; // circular indexing
        data[rear] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity * 2;
            System.out.println("Queue capacity: " + oldCapacity + " -> " + newCapacity);

            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(first + i) % data.length];
            }
            data = newData;
            first = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(first + i) % data.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("] and Inner Array: [");

        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}