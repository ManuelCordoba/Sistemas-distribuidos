package rmi1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 310
 */
abstract class CifrarD {
    String cadena;
    String pd = "ABCD EFGHIJKLMNOPQRSTUVWXYZ!-abcdefghijklmnopqrstuvwxyz0123456789";
    String pc = "0Aa1_bB2Cc3Dd4Ee5Ff6Gg7Hh8Ii !9JjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    public CifrarD(String cadena){
    this.cadena = cadena;
    }
    public abstract String Cifrado();
}
