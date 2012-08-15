/*
 * The Main class the runs the classes for the Lexcial Analyzer
 */

package com.borromeo.main;

import java.io.*;
import java.lang.*;
import java.util.*;

import com.borromeo.analyzer.LexicalAnalyzer;
import com.borromeo.token.Tokens;

public class MicroCompiler {
        
    /**
     * Creates a new instance of <code>MicroCompiler</code>.
     */
    public MicroCompiler() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader stdin = new BufferedReader(new FileReader("Input.mcr"));
        
        String input;
        StringBuffer sb =  new StringBuffer(32);
        Tokens myToken = new Tokens();
        LexicalAnalyzer LA = new LexicalAnalyzer();
        
        while(stdin.ready()){
        	
        	input = stdin.readLine();
        	LA.Scanner(input);
        	
        }//end while
        LA.displayTokens();
        LA.writeToFile();
        
    }//end main
    
}//end MicroCompiler
