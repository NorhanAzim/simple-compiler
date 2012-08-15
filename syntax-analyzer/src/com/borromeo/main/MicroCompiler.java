/*
 * The Main class the runs the classes for the Syntax Analyzer
 */

package com.borromeo.main;

import java.io.*;
import java.lang.*;
import java.util.*;

import com.borromeo.analyzer.LexicalAnalyzer;
import com.borromeo.analyzer.SyntaxAnalyzer;
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
        
        int lineCount = 0;
        String input;
        StringBuffer sb =  new StringBuffer(32);
        Tokens myToken = new Tokens();
        LexicalAnalyzer LA = new LexicalAnalyzer();
        
        while(stdin.ready()){
        	
        	input = stdin.readLine();
        	lineCount++;
        	LA.Scanner(input.trim(), lineCount);
        	
        }//end while
        SyntaxAnalyzer SA = new SyntaxAnalyzer(LA.getTokens(),0);
        
        //SA.displayTokens();
        SA.Program();
        
        LA.writeToFile();
        
    }//end main
    
}//end MicroCompiler
