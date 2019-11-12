/**
 *
 *  @author Baka Krzysztof S16696
 *
 */

package zad1;


import java.io.*;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomersPurchaseSortFind {
    public List<String> wordList;
    public List<Customer> customers = new ArrayList<>();
    public List<Customer> toSearch;
    Comparator<Customer> name_comparator;
    Comparator<Customer> prices_comparator;


    public void readFile(String path) {
        String[] readWord;
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String s_reader;
            while ((s_reader = reader.readLine())!=null){
                readWord = s_reader.split(";");
                wordList = new ArrayList<>();
                for(int i=0;i<readWord.length;i++) {
                    wordList.add(readWord[i]);
                }
                Customer customer_to_add = new Customer(wordList.get(0),wordList.get(1),wordList.get(2),Double.parseDouble(wordList.get(3)),Double.parseDouble(wordList.get(4)));
                customers.add(customer_to_add);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        toSearch=new ArrayList<>(customers);
    }


    public void showSortedBy(String option) {
        Collator PL = Collator.getInstance(new Locale("pl", "PL"));
        if(option.equals("Nazwiska")){
            System.out.println("Nazwiska");
            name_comparator = Comparator.comparing(Customer::getName, (s1,s2) ->{
                return PL.compare(s1.toLowerCase(),s2.toLowerCase());

            }).thenComparing(Customer::getId, (s1,s2) ->{
                return s1.compareTo(s2);
            });


            customers.sort(name_comparator);
            for(int i=0;i<customers.size();i++){
                System.out.println(customers.get(i).toString());
            }
        }


        if(option.equals("Koszty")){
            System.out.println("Koszty");
            prices_comparator = Comparator.comparing(Customer::getPrice, (s1,s2)->{
               return s2.compareTo(s1);
            }).thenComparing(Customer::getName, (s1,s2)->{
                return PL.compare(s1.toLowerCase(),s2.toLowerCase());
            });

            customers.sort(prices_comparator);
            for(int i=0;i<customers.size();i++){
                System.out.println(customers.get(i).toString() +" "+customers.get(i).p.toString());
            }
        }
        System.out.println();
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " +id);
        for(int i=0;i<toSearch.size();i++){
            if(toSearch.get(i).id.equals(id)){
                System.out.println(toSearch.get(i).toString());
            }
        }
        System.out.println();
    }
}
