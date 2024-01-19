/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author tarek
 */
public class GuessNumbers {
    private static int _RANDOMGEN = 0;
    public static int _randomNumber(){
      _RANDOMGEN = (int) Math.round(Math.random() * 100);
        return _checkIfZero(_RANDOMGEN)   ;
    }
    private static int _checkIfZero(int num){
        int newNum = 0;
        if(num == 0){
        newNum = _randomNumber();
    }else{
            newNum = num;
        }
        return newNum;
    }
}
