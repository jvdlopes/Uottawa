import javax.lang.model.element.Element;


public class ITIStringBuffer {
    
    SinglyLinkedList list = new SinglyLinkedList<String>();

    public ITIStringBuffer() {
    }

    public ITIStringBuffer(String  firstString){
        list.addFirst(firstString);
    }

    public void append(String nextString){
        list.add(nextString);
    }

    public String toString(){
        public String(char[] "");
        String ans = "";
        for(Object x:list){
            ans = ans +(String)x;
        }
        return ans;
    }

}
