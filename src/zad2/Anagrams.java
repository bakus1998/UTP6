/**
 *
 *  @author Baka Krzysztof S16696
 *
 */

package zad2;


import java.io.*;
import java.util.*;

public class Anagrams {
    public List<String> wordList;
    public List<List> allLists;


    public Anagrams(String path) {
        wordList = new ArrayList<>();
        String[] readWord;
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String s_reader;
            while ((s_reader = reader.readLine())!=null){
                readWord = s_reader.split("\\s");
                for(int i=0;i<readWord.length;i++) {
                    wordList.add(readWord[i]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean isAnagram(String val1, String val2) {
        char[] f_word = val1.toCharArray();
        char[] s_word = val2.toCharArray();
        Arrays.sort(f_word);
        Arrays.sort(s_word);

        boolean toReturn = Arrays.equals(f_word,s_word);
        return toReturn;
    }


    public List<List> getSortedByAnQty() {
        allLists = new ArrayList<>();
        List<String> duplicate = new ArrayList<>();
        List<String> valToAdd;
        //System.out.println(wordList);

        for (int i=0;i<wordList.size();i++) {
            if (duplicate.contains(wordList.get(i))==false) {
                valToAdd = new ArrayList<>();
                for (int j=0;j<wordList.size();j++) {
                    if (isAnagram(wordList.get(i), wordList.get(j))) {
                        duplicate.add(wordList.get(j));
                        valToAdd.add(wordList.get(j));
                    }
                    //System.out.println(duplicate);
                }
                Collections.sort(valToAdd);
                allLists.add(valToAdd);
            }

        }

        allLists.sort(new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                if(o1.size()>o2.size()){
                    return -1;
                } else if(o1.size()<o2.size()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        return allLists;

    }

    public String getAnagramsFor(String val) {
        List<String> toCheck;
        for (int i=0;i<allLists.size();i++) {
            toCheck = new ArrayList<String>(allLists.get(i));
            for (int j=0;j<toCheck.size();j++) {
                if(isAnagram(toCheck.get(j),val)){
                    toCheck.remove(val);
                    return val+": " + toCheck;
                }
            }
        }
        return null;
    }
}