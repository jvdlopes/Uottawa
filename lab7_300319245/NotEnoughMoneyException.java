public class NotEnoughMoneyException extends IllegalStateException{
    private double have;
    private double request;
    public NotEnoughMoneyException(double have, double request){
        this.have = have;
        this.request = request;
    }

    public double getAmount(){
        return request;
    }

    public double getBalance(){
        return have;
    }

    public double getMissingAmount(){
        return request-have;
    }

    public String getMessage(){
        return ("you have not enought money to witdraw "+ request+"$");
    }
}
