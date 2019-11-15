# ZAD 1
W pliku customers.txt umieszczonym w katalogu {user.home} znajdują się dane o zakupach klientów w postaci:

id_klienta; nazwisko i imię; nazwa_towaru;cena;zakupiona_ilość

Identyfikator klienta ma postać

    cNNNNN
    gdzie N cyfra ze zbioru [0...9]
    np.
    c00001;Kowalski Jan;bułka;2;100

Wczytać dane z pliku i wypisać na konsoli w kolejnych wierszach:
poprzedzone napisem "Nazwiska" dane posortowane wg nazwisk w porządku rosnącym (porządek rekordów z tymi samymi nazwiskami jest określany przez identyfikatory klientów - rosnąco),

poprzedzone napisem "Koszty" dane posortowane wg kosztów zakupów w porządku malejącym (porządek rekordów z tymi samymi kosztami jest określany przez identyfikatory klientów - rosnąco) z dodatkowym dopiskiem na końcu w nawiasach:  koszty:  kosztZakupu (np. (koszt: 200.0)),

poprzedzone napisem "Klient c00001" dane o wszystkich zakupach  klienta  o identyfikatorze "c00001" (w odrębnych wierszach)

poprzedzone napisem "Klient c00002" - w odrębnych wierszach -dane o wszystkich zakupach  klienta  o identyfikatorze "c00002"  (w odrebnych wierszach) (a więc uwaga: w pliku muszą być klienci o identyfikatorach c00001 i c00002)


Np. dla pliku w postaci:

    c00004;Nowak Anna;banany;4.0;50.0
    c00003;Kowalski Jan;mleko;4.0;5.0
    c00001;Kowalski Jan;mleko;4.0;10.0
    c00001;Kowalski Jan;mleko;5.0;2.0
    c00002;Malina Jan;mleko;4.0;2.0
    c00002;Malina Jan;chleb;3.0;5.0
    c00001;Kowalski Jan;bulka;2.0;100.0


Nazwiska

    c00001;Kowalski Jan;mleko;4.0;10.0
    c00001;Kowalski Jan;mleko;5.0;2.0
    c00001;Kowalski Jan;bulka;2.0;100.0
    c00003;Kowalski Jan;mleko;4.0;5.0
    c00002;Malina Jan;mleko;4.0;2.0
    c00002;Malina Jan;chleb;3.0;5.0
    c00004;Nowak Anna;banany;4.0;50.0

Koszty

    c00001;Kowalski Jan;bulka;2.0;100.0 (koszt: 200.0)
    c00004;Nowak Anna;banany;4.0;50.0 (koszt: 200.0)
    c00001;Kowalski Jan;mleko;4.0;10.0 (koszt: 40.0)
    c00003;Kowalski Jan;mleko;4.0;5.0 (koszt: 20.0)
    c00002;Malina Jan;chleb;3.0;5.0 (koszt: 15.0)
    c00001;Kowalski Jan;mleko;5.0;2.0 (koszt: 10.0)
    c00002;Malina Jan;mleko;4.0;2.0 (koszt: 8.0)

Klient c00001

    c00001;Kowalski Jan;mleko;4.0;10.0
    c00001;Kowalski Jan;mleko;5.0;2.0
    c00001;Kowalski Jan;bulka;2.0;100.0

Klient c00002

    c00002;Malina Jan;mleko;4.0;2.0
    c00002;Malina Jan;chleb;3.0;5.0

Uwaga: programy nie dające pokazanej formy wydruku otrzymują 0 punktów.

Niezbędne jest stworzenie klasy, opisującej zakupy klientów (Purchase) i operowanie na jej obiektach. Nie przyjmuję rozwiązań działających na "surowych" Stringach.

Aplikacja powinna zawierać klasy Purchase,  CustomersPurchaseSortFind oraz Main.
Ta ostatnia ma obowiązakową postać (nie wolno jej zmienić):


      public class Main {
  
        public static void main(String[] args)  {
          CustomersPurchaseSortFind cpsf = new CustomersPurchaseSortFind();
          String fname = System.getProperty("user.home") + "/customers.txt";
          cpsf.readFile(fname);
          cpsf.showSortedBy("Nazwiska");
          cpsf.showSortedBy("Koszty");
  
          String[] custSearch = { "c00001", "c00002" };
  
          for (String id : custSearch) {
            cpsf.showPurchaseFor(id);
          }
        }
  
      }
      

Generator projektów utworzy wymagane klasy.

Wykonanie programu rozpoczyna się od metody main(...) w klasie Main.

Uwaga: nazwa pliku jest obowiązkowe. Niespełnienie tego warunku skutkuje brakiem punktów.
Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.

Uwaga: aby dowiedzieć się który  katalog jest  {user.home} i umieścić w nim plik testowy można z poziomu Javy użyć:
System.getProperty("user.home");
Np. jeśli identyfikatorem użytkownika jest Janek, to w Windows 7 katalog {user.home} to C:\Users\Janek.

Należy samodzielnie utworzyć testowy plikii umieścić je w katalogu {user.home}.



# ZAD 2


W pliku allwords.txt, znajdującym się w katalogu  {user.home} zapisane są (rozdzielone białymi znakami) słowa.
Znaleźć wszystkie anagramy, które można utworzyć z  tych słów i wypisac je jako listy słów na konsoli w porządku liczby anagramów.

Przy takiej samej liczbie anagramów listy wypisywane są w porządku alfabetycznym pierwszego słowa na liście.

Dla realizacji tego zadania w klasie Anagrams utworzyć metodę getSortedByAnQty(), która zwraca listę list słów będacych anagramami, uporządkowaną wedle podanych wyżej kryteriów.
W klasie tej dostarczyć także metody String getAnagramsFor(String word), która zwraca napis, przedstwiający listę anagramów dla podanego słowa w postaci:


słowo: [ anagram1, anagram2, ... , anagramN]


Jeśli  słowo nie ma nagramow lista jest pusta (po dwukropku mamy [] ). Jesli podanego słowa nie ma w pliku allwords.txt to po dwukropku powinnien znaleźć się napis null.

Słowa dla których będziemy szukać anagramów, wczytywane są z pliku o nazwie {user.home}/wordsToFind.

Rozwiązanie zadania ułatwi klasa Main, utworzona przez generator projektów. Ma ona następującą postać (nie wolno jej zmieniać):

    import java.io.*;
    import java.util.*;

    public class Main {

      public static void main(String[] args) throws FileNotFoundException {
        String home = System.getProperty("user.home");
        String allWords = home + "/allwords.txt";
        Anagrams an = new Anagrams(allWords);
        for(List<String> wlist : an.getSortedByAnQty()) {
          System.out.println(wlist);
        }
        System.out.println("************************");
        Scanner scan = new Scanner(new File(home, "wordsToFind.txt"));
        while(scan.hasNext()) {
          System.out.println(an.getAnagramsFor(scan.next()));
        }
        scan.close();
      }

    }

Przykładowo, jeśli plik allwords.txt zawiera  słowa:

    andes danes deans evil gals lags levi live sedan
    slag streets testers uprising veil vile

a plik wordsToFind słowa:

    evil streets uprising

- to program (zaczynający wykonanie od obowiązkowej klasy Main) powinien wyprowadzić następującą informację

    [evil, levi, live, veil, vile]
    [andes, danes, deans, sedan]
    [gals, lags, slag]
    [streets, testers]
    [uprising]
    ************************
    evil: [levi, live, veil, vile]
    streets: [testers]
    uprising: []


Uwaga: programy nie dające pokazanej formy wydruku otrzymują 0 punktów.

Uwaga: nazwy i umiejscowienie plików są obowiązkowe. Niespełnienie tego warunku skutkuje brakiem punktów.

Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.

Uwaga: aby dowiedzieć się który  katalog jest  {user.home} i umieścić w nim pliki testowe można z poziomu Javy użyć:
System.getProperty("user.home");

Np. jeśli identyfikatorem użytkownika jest Janek, to w Windows 7 katalog {user.home} to C:\Users\Janek.

Należy samodzielnie utworzyć testowe pliki i umieścić je w katalogu {user.home}


