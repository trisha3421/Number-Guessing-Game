/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
  import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 *
 * @author tarek
 */
public class Gui {
    public static void _centerFrame(JFrame frame){
        Rectangle rec = frame.getBounds();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width - rec.width)/2,(dim.height - rec.height)/2);
    }
    public void setIconFrame(JFrame frame){
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Asset/logo.png")));
    }
    public static void _integerOnly(KeyEvent evt){
        char _character = evt.getKeyChar();
        if(Character.isDigit(_character)
            || _character == KeyEvent.VK_SPACE
            || _character == KeyEvent.VK_DELETE
            || _character == KeyEvent.VK_SLASH){
        
        }else{
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    public  static void _message(String message, int errorTye){
        
   switch(errorTye){
       case 0:
        JOptionPane.showMessageDialog(null,message,"ERROR",JOptionPane.ERROR_MESSAGE);
           
                 break;
           case 1:
               JOptionPane.showMessageDialog(null,message,"SUCCESS",JOptionPane.INFORMATION_MESSAGE);
           break;
           case 2:
              JOptionPane.showMessageDialog(null,message,"WARNING",JOptionPane.WARNING_MESSAGE); 
           break;
   }
    }
// private static String patFileBestScore = System.getProperty("User.dir")+"/src/GUI/bestscore.ini"; 
// public static int getCurrentBestScore(){
//   int bestScore;
//   String line, newLine ="";
//  try{
//     BufferedReader buff = new BufferedReader(new FileReader(patFileBestScore)); 
//     while((line = buff.readLine()) != null){
//        newLine = line; 
//     }
//  }catch(FileNotFoundException e){    
// } 
//  catch(IOException ex){
//      //Logger.getLogger(Gui.class.getName().lines(Level.SEVERE,null,ex);
//              //log(Level.SEVERE,null,ex);
// }
//  bestScore = Integer.parseInt(newLine.substring(newLine.indexOf("[")+1, newLine.indexOf("]") ));
//  return bestScore;   
// }
// public static void setNewBestScore(String newContent){
//     try{
//        File fileToUpdate = new File(patFileBestScore);
//         try(FileWriter fileWrite = new FileWriter(fileToUpdate)){
//           fileWrite.write(newContent);
//           fileWrite.close();
//         }
//     }catch(Exception e){
//         
//     }
//     
// }
private static String patFileBestScore = System.getProperty("user.dir") + "/src/GUI/bestscore.ini";

public static int getCurrentBestScore() {
    int bestScore = 0; // Initialize with a default value in case file is empty or format is unexpected
    String line;
    try (BufferedReader buff = new BufferedReader(new FileReader(patFileBestScore))) {
        String newLine = null;
        while ((line = buff.readLine()) != null) {
            newLine = line;
            // Assuming the last line contains the best score in the format "[score]"
        }
        if (newLine != null && newLine.matches("\\[\\d+\\]")) {
            bestScore = Integer.parseInt(newLine.substring(newLine.indexOf("[") + 1, newLine.indexOf("]")));
        }
    } catch (FileNotFoundException e) {
        // Handle file not found exception
        e.printStackTrace(); // Or log the exception
    } catch (IOException ex) {
        // Handle IO exception
        ex.printStackTrace(); // Or log the exception
    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
        // Handle parsing or string index out of bounds exceptions
        ex.printStackTrace(); // Or log the exception
    }
    return bestScore;
}

public static void setNewBestScore(String newContent) {
    try (FileWriter fileWrite = new FileWriter(patFileBestScore)) {
        fileWrite.write(newContent);
        // No need to explicitly close, try-with-resources will take care of it
    } catch (IOException e) {
        // Handle IO exception
        e.printStackTrace(); // Or log the exception
    }
}


}
