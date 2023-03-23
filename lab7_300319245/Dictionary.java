import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if(key==null || value==null){
            throw new NullPointerException("either the key or the value was null");
        }
        if(count == elems.length){
            this.increaseCapacity();
        }
        elems[count]= new Pair(key, value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] temp = new Pair[(getCapacity()+INCREMENT)];
        for(int i= 0;i<getCapacity();i++){
            temp[i] = elems[i];
        }
        elems = temp;
    }

    @Override
    public boolean contains(String key) {
        if(key==null){
            throw new NullPointerException();
        }
        for(int i = 0; i < count; i++){
            if(elems[i].getKey()==key){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        if(key==null){
            throw new NullPointerException();
        }
        if(!contains(key)){
            throw new NoSuchElementException();
        }
        Integer ans =0;
        for(int i =0; i< count;i++){
            if(elems[i].getKey()==key){
                ans = elems[i].getValue();
            }
        }
        return ans;
    }

    @Override
    public void replace(String key, Integer value) {
        if(key==null || value==null){
            throw new NullPointerException();
        }
        if(!contains(key)){
            throw new NoSuchElementException();
        }
        for(int i =0; i< count;i++){
            if(elems[i].getKey()==key){
                elems[i].setValue(value);
            }
        }
    }

    @Override
    public Integer remove(String key) {
        if(key==null){
            throw new NullPointerException();
        }
        if(!contains(key)){
            throw new NoSuchElementException();
        }
        int split = 0;
        Integer ans = 0;
        if(contains(key)){
            ans = get(key);
            for(int i = 0; i < count; i++){
                if(elems[i].getKey()==key){
                    split = i;
                }
            }
    
            Pair[] temp = new Pair[count];
            for(int i =0; i<split;i++){
                temp[i] = elems[i];
            }
            for(int i = split; i <(count-1);i++){
                temp[i] = elems[i+1];
            }
            temp[(temp.length-1)] = null;
            elems = temp;
            count --;
        }
        return ans;
    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count-1; i >= 0 ; i--) {
            res += elems[i];
            if(i > 0) {
                res += ", ";
            }
        }
        return res +"]}";
    }

}