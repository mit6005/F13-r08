package lists;

public interface ImList<E> {
    /**
     * @return a list with e as its first element, 
     * followed by this list as its remaining elements.
     */
    public ImList<E> cons(E e);
    
    /**
     * @return the first element of this list.  
     * Requires this list to be nonempty.
     */
    public E first();
    
    /**
     * @return the rest of this list after removing the first element.  
     * Requires this list to be nonempty.
     */
    public ImList<E> rest();
    
    /**
     * @return 
     */
    public boolean isEmpty();
}