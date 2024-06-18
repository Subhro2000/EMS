/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ems;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Subhro Ghosh
 */
public class GenHashedPassword
{
    
    public static String hashedPassword(char[] pass, char[] uName)
    {
        
        char passName[] = new char[pass.length+uName.length];
        
        System.arraycopy(pass, 0, passName, 0, pass.length);
        System.arraycopy(uName, 0, passName, pass.length, uName.length);
        
        byte bytePass[] = charArrayToByteArray(passName);
        
        StringBuilder sb = new StringBuilder();
        try
        {
            MessageDigest alg = MessageDigest.getInstance("SHA-1");
            alg.update(bytePass);
            byte hash[] = alg.digest();
            
            for (byte b : hash)
            {
                String s = String.format("%02X", b);
                sb.append(s);
            }
            
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(UpdatePasswordDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        System.out.println(sb.toString());
        return sb.toString();
    }
    
    
    private static byte[] charArrayToByteArray(char[] chr)
    {
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream(chr.length*2);
        DataOutputStream dos = new DataOutputStream(bos);
        
        try
        {
            for (char c : chr)
            {
                dos.writeChar(c);
            }
            dos.close();
        } catch (IOException ex)
        {
        }
        
        return bos.toByteArray();
        
    }    
    
}
