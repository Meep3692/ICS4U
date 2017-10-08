/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchinggameswaine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipFile;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

/**
 *
 * @author Awoo
 */
public class Theme {
    ArrayList<ImageIcon> cardFaces;
    ImageIcon back;
    ImageIcon done;
    
    public Theme(){
        cardFaces = new ArrayList();//Initialise faces list
    }
    
    public static Theme loadTheme(String path) throws IOException{
        Theme theme = new Theme();//Theme to return
        ZipFile file = new ZipFile(path);//Open theme file
        theme.back = iconFromZip("back.png", file);//Load back and done images
        theme.done = iconFromZip("done.png", file);
        try{//Add as many cards as there are
            int i = 0;//Card id
            while(true){//Keep going, exception will break loop
                theme.cardFaces.add(iconFromZip(i + ".png", file));//Load image
                i++;//Increment
            }
        }catch(NullPointerException e){
            //Probably out of cards
        }
        return theme;
    }
    
    private static ImageIcon iconFromZip(String name, ZipFile file) throws IOException{
        InputStream stream = file.getInputStream(file.getEntry(name));//Get stream
        ImageIcon icon = new ImageIcon(ImageIO.read(stream));//Make into image icon
        return icon;
    }
}
