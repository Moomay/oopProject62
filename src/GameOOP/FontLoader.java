package GameOOP;


import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jame
 */
public class FontLoader {
    
    public static Font loadFont(String path, float size){
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch(FontFormatException | IOException e){
            System.out.println(e);
        }
        return null;
        
    }
}
