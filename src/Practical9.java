
class ShareMarket{

    private int availableShares=200;

    synchronized void buyShares(String buyer,int quantity){  //  buyShare :method name .
        System.out.println(buyer+" wants to buy "+quantity+" shares");

        if (quantity<=availableShares){
            System.out.println("Order processing for "+buyer);
            availableShares=availableShares-quantity;
            System.out.println(buyer+" successfully buy "+quantity+" shares");
            System.out.println("Available shares "+availableShares);
        }

        else{
            System.out.println("Order Failed!!");
        }
    }
}

class Buyer extends Thread{
    private ShareMarket market;
    private int quantity;

    //Constructor
    Buyer(ShareMarket market, String name, int quantity ) {
        super(name);
        this.market = market;
        this.quantity = quantity;
    }
     @Override
             public void run(){
         market.buyShares(getName(),quantity);


        }

    }



public class Practical9 {
    public static void main(String[] args){
        ShareMarket s= new ShareMarket();
       Buyer b1= new Buyer(s,"Parv",20);
        Buyer b2= new Buyer(s,"Dev",180);

       b1.start();
        b2.start();

    }

}
