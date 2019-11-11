/**
 *
 *  @author Baka Krzysztof S16696
 *
 */

package zad1;

public class Purchase {
    public double number;
    public double price;
    public double afterCalc;

    public Purchase(double number,double price){
        this.number=number;
        this.price=price;
    }

    public double calc(){
        afterCalc = number*price;
        return afterCalc;
    }

    public String toString(){
        return "(koszt: " + afterCalc + ")";
    }

}
