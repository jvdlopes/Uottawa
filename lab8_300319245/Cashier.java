public class Cashier {
    ArrayQueue<Customer> queue;
    Customer currentCustomer;
    int totalCustomerWaitTime;
    int customersServed;
    int totalItemsServed;

    public Cashier(){
        queue = new ArrayQueue<Customer>();
        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;
        currentCustomer = null;
    }

    public void addCustomer(Customer c){
        queue.enqueue(c);
    }

    public int getQueueSize(){
        return queue.size();
    }

    public void serveCustomers(int currentTime){
        if(currentCustomer == null && !queue.isEmpty()){
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += (currentTime - currentCustomer.getArrivalTime());
        }
        if(currentCustomer != null){
            currentCustomer.serve();
        
            if(currentCustomer.getNumberOfItems()==0){
                customersServed ++;
                totalItemsServed += currentCustomer.getNumberOfServedItems();
                currentCustomer = null;
            }
        }
    }

    public int getTotalCustomerWaitTime(){
        return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed(){
        return customersServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }
}
