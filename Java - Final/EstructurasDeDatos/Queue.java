package EstructurasDeDatos;


public class Queue<ELEMENT> {
 
    //region Constants
 
    private final static Integer defaulDimension = 5;
 
    //endregion
 
    //region Attributes
 
    private ELEMENT [] data;
    private int head;
    private int tail;
    private int count;
 
    //endregion
 
    //region Constructors
 
    public Queue() {
        this(Queue.defaulDimension);
    }
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    //endregion
 
    //region Queue Internal Methods
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    //endregion
 
 
    public boolean add(ELEMENT element) {
 
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
 
        return true;
    }
 
    public ELEMENT element() {
 
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
 
        return this.data[this.head];
    }
 
    public boolean offer(ELEMENT element) {
 
        if (this.size() >= this.data.length) {
            return false;
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
 
        return true;
    }
 
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }
 
        return this.data[this.head];
    }
 

    public ELEMENT poll() {
        if (this.size() <= 0) {
            return null;
        }
 
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
 
        return result;
    }
 
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
 
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
 
        return result;
    }
    //endregion
 
 
    //region Override Object basic methods
 
    @Override
    public String toString() {
 
        if (this.size() <=0) {
            return "";
        }
 
        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());
 
        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }
 
        sb.append("]");
        return sb.toString();
    }
    //endregion
 
 
    //region Collection Methods
 
    public boolean isEmpty() {
        return this.count <= 0;
    }
    public boolean isFull() {
    	return this.count>=this.data.length;
    }
 
    public int size() {
        return this.count;
    }
 
    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
    //endregion
 
    public Queue<Integer> intercalarColas(Queue<Integer> cola1, Queue<Integer> cola2){
    	Queue<Integer> unionColas= new Queue<Integer>(cola1.size() + cola2.size());
    	Object [] cola1ToArray= cola1.toArray();
    	Object [] cola2ToArray= cola2.toArray();
    	int i= 0;
    	while(i<cola1.size() && i<cola2.size()) {
    		unionColas.offer((Integer) cola1ToArray[i]);
    		unionColas.offer((Integer) cola2ToArray[i]);
    		++i;
    	}
    	
    	System.out.println("Colas intercaladas correctamente!\n");
    	return unionColas;
    }
    
    //endregion
 
}