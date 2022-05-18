// Java program to implement LRU cache
// using LinkedHashSet
import java.util.*;
  
class LRUCache2 {
  
    Set<Integer> cache;
    int capacity;
  
    public LRUCache2(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }
  
    // This function returns false if key is not
    // present in cache. Else it moves the key to
    // front by first removing it and then adding
    // it, and returns true.
    public boolean get(int key)
    {
        if (!cache.contains(key)){
            return false;
			}
        cache.remove(key);
        cache.add(key);
        return true;
    }
  
    /* Refers key x with in the LRU cache */
    public void refer(int key)
    {        
        if (get(key) == false)
           put(key);
		   
		   System.out.print("   Key="+key+"       ");
		   display();
		   System.out.println();
    }
  
    // displays contents of cache in Reverse Order
    public void display()
		{
			  LinkedList<Integer> list = new LinkedList<>(cache);
				
			  // The descendingIterator() method of java.util.LinkedList
			  // class is used to return an iterator over the elements
			  // in this LinkedList in reverse sequential order
			  Iterator<Integer> itr = list.descendingIterator(); 
				
			  while (itr.hasNext())
					System.out.print(itr.next() + "  ");
		}
		
    
    public void put(int key)
    {
          
      if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
			System.out.println("  firstkey="+firstKey+"  ");
			
            cache.remove(firstKey);
			    System.out.print("  After firstkey is removed ->  ");
		     	display();
				System.out.println();
        }
  
        cache.add(key);
		
		       System.out.print("After key "+key+ " is added ->  ");
				     	display();
				System.out.println();
    }
      
    public static void main(String[] args)
    {
        LRUCache2 ca = new LRUCache2(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
		System.out.print("Final results=");
        ca.display();
    }
}