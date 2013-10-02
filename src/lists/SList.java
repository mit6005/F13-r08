package lists;

public class SList implements ImList<Integer> {
    private final String s;

    /*
     * Examples of valid representations:
     *   s="1$2$3$" represents the integer list 1,2,3
     *   s=""       represents the empty list
     *   s="-5$30042$" represents the list -5,30042 
     * 
     * Rep invariant: 
     *   s != null
     *   s contains only digits 0-9, dashes - (for negative numbers), and terminators $
     *   s consists of a sequence of numbers (e.g. "5", "-3", "0") terminated by $  
     *    
     * Abstraction function: maps representation space R (Strings) to abstract space A (list of integers)
     *   A string s containing "num_1$num_2$...num_k$" 
     *   maps to the sequence of integers num_1,num_2,...,num_k
     */
    
    /**
     * Implements the empty() operation for ImList<Integer>
     * @return empty list
     */
    public SList() {
        s = "";
    }
    
    // This private constructor is used only internally
    private SList (String s) {
        this.s = s;
    }
    
    public ImList<Integer> cons(Integer e) {
        return new SList(e.toString() + "$" + this.s);
    }
    
    public Integer first() {
        return Integer.valueOf(s.substring(0, s.indexOf("$")));
        // Why is it OK to not check the return value of s.indexOf()?  It might return -1!
        // This is not good defensive code, but it does meet the spec for ImList<E>.first() (go read it).
        // The spec says that the client is only allowed to call first() on a nonempty list.
        // If that precondition isn't satisfied, then this method can do anything.  So we
        // can assume that the list is nonempty and hence that there's a $ in the string.
    }
    
    public ImList<Integer> rest() {
        return new SList(s.substring(s.indexOf("$")+1));
        // See the note above about indexOf()
    }
    
    public boolean isEmpty() {
        return s.isEmpty();
    }
}
