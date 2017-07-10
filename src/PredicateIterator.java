import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PredicateIterator<T> {

    private Iterator<T> iter;
    private Predicate pred;
    private T argument;
    private List<T> myList = new ArrayList<>();
    private int i;

    public PredicateIterator(Iterator<T> iter, Predicate<T> pred, T argument) {
        this.iter = iter;
        this.argument = argument;
        if(pred instanceof PredicateEndsWith) {
            this.pred = new PredicateEndsWith<>();
        } else if(pred instanceof PredicateStartsWith) {
            this.pred = new PredicateStartsWith<>();
        }
        while(this.iter.hasNext()) {
            T t = this.iter.next();
            this.myList.add(t);
            this.iter.remove();
        }
        System.out.println(myList);



    }

    public boolean hasNext() {
        int i = 0;
        if(this.iter == null) return false;
        for(T t : myList) {
            if(this.pred.predicate(t, this.argument)) {
                i++;
            }
        }
        if(i == 0 && !this.iter.hasNext()) return false;
        return true;
    }

    public T next() throws NoSuchElementException {
        if(this.myList.isEmpty()){
            throw new NoSuchElementException();
            //return null;
        }
        T t = myList.get(0);
        this.myList.remove(0);
        if(this.pred.predicate(t, this.argument)) {
            return t;
        } return next();

        /*T t = this.iter.next();
        this.myList.add(t);
        this.iter.remove();

        if(this.pred.predicate(t, this.argument)) {
            return t;
        } return next();*/

    }

    public void remove() {
        this.iter.remove();

    }

}
