package zad1;

public class Customer {
    public String id;
    public String name;
    public String thing;
    public double val1;
    public double val2;
    public Purchase p;

    public double price;

    public Customer(String id, String name, String thing, double val1, double val2){
        this.id=id;
        this.name=name;
        this.thing=thing;
        this.val1=val1;
        this.val2=val2;
        p = new Purchase(val1,val2);
        price=p.calc();
    }

    public String toString(){
        return id+ ";" + name+ ";"+thing+ ";"+val1+ ";"+ val2;
    }

    public String getName() {
        return name;
    }

    public double getVal1() {
        return val1;
    }

    public double getVal2() {
        return val2;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
