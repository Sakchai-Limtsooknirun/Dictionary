package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {

    Map<String , Vocabulary> dic = new HashMap<String, Vocabulary>() ;

    public void add(String word , Vocabulary detail){
        dic.put(word,detail);
    }

    public String ShowWord(String key){
        return dic.get(key).getName();
    }

    public String ShowMeaning(String key){
        return dic.get(key).getMeaning();
    }

    public String ShowPartOfSpeech(String key){
        return dic.get(key).getPartOfSpeech();
    }

    public String ShowExample(String key){
        return dic.get(key).getExample();
    }


    public void setWord(String key,String NewName){
        dic.get(key).setName(NewName);
    }

    public void setMeaning(String key , String NewMeaning){
        dic.get(key).setMeaning(NewMeaning);
    }

    public void setPartOfSpeech(String key , String NewPartOfSpeech){
        dic.get(key).setPartOfSpeech(NewPartOfSpeech);
    }

    public void setExample(String key , String NewExample){
        dic.get(key).setExample(NewExample);
    }

    public void remove(String key){
        dic.remove(key);
    }


    public String toString(String key) {
        return dic.get(key).toString();
    }

    public int size(){
        return dic.size();
    }

    public Set<String> wordList() {
        return dic.keySet();
    }
    public boolean contains(String w){
        return dic.containsKey(w);
    }

    public String format(MyFormatter format) {
        return format.format(dic);
    }

}
