/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;


import java.util.LinkedList;

/**
 *
 * @author Jame
 */
public class Word {
    
    
    public static Word w1 = new Word("ABC", "บินได้", "ทดสอบ", "ทดสอบ", 0);
    private String hint1;
    private String hint2;
    private String hint3;
    private String word;
    private int id;
    public Word(String word,String hint1,String hint2, String hint3,int id){
        this.word = word;
        this.hint1 = hint1;
        this.hint2 = hint2;
        this.hint3 = hint3;
        this.id = id;
    }
    
    public static Word getW1() {
        return w1;
    }

    public String getHint1() {
        return hint1;
    }

    public String getHint2() {
        return hint2;
    }

    public String getHint3() {
        return hint3;
    }

    public String getWordString() {
        return word;
    }

    public int getId() {
        return id;
    }
    
}
