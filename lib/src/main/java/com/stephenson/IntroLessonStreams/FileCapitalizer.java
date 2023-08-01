package com.stephenson.IntroLessonStreams;

import java.io.*;
import java.io.IOException;

/****

<b>Title:</b> FileCapitalizer.java<br>
<b>Project:</b> intro-programming-lib<br>
<b>Description:</b> <br>
<b>Copyright:</b> Copyright (c) 2023<br>
<b>Company:</b> Silicon Mountain Technologies<br>
@author Cole Stephenson
@version 1.0
@since Jul 31 2023
@updates:

****/

public class FileCapitalizer {
	
	//Member variable for the new output file capitalized
	private File outputToUpperCase;
	
	/**
	 * main method to execute class methods and write resulting output file
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//Instantiate the FileCapitalizer
		FileCapitalizer fileCapitalizer = new FileCapitalizer(new File("/home/cole-smt/eclipse-workspace/intro-lessons-streams/lib/src/main/java/com/stephenson/IntroLessonStreams/files/outputToUpperCase.txt"));
		
		//Invoke writeCapitalizedFile() to write the capitalized chars to the end file
		fileCapitalizer.writeCapitalizedFile(new FileHandler(new File("/home/cole-smt/eclipse-workspace/intro-lessons-streams/lib/src/main/java/com/stephenson/IntroLessonStreams/files")));
	}
	
	/**
	 * Constructor for the class
	 * @param output file for capitalized data
	 */
	public FileCapitalizer(File outputToUpperCase) {
		this.outputToUpperCase = outputToUpperCase;
	}
	
	/**
	 * Getter for the output member class File
	 * @return member output File 
	 */
	public File getOutputToUpperCase() {
		return outputToUpperCase;
	}
	
	/**
	 * Setter for the output member class File
	 * @param outputToUpperCase file to be set as class member File
	 */
	public void setOutputToUpperCase(File outputToUpperCase) {
		this.outputToUpperCase = outputToUpperCase;
	}
	
	/**
	 * Method to stream file generated from FileHandler to output member File 
	 * with all chars capitalized
	 * @param FileHandler instantiation to provide input file to the reader
	 * @throws IOException
	 */
	public void writeCapitalizedFile(FileHandler handler) throws IOException {
		
		////Instantiate int for current character in the input file stream
		int c;
		
		//Assign the output from handler.writeFile() to a new File variable
		File handlerOutput = handler.writeFile();
		
		//Instantiate a new FileReader with handlerOutput
		FileReader reader = new FileReader(handlerOutput);
		
		//Instantiate a new FileWriter with the outputToUpperCase member variable
		FileWriter writer = new FileWriter(outputToUpperCase);
		
		//Stream the handlerOutput to the outputToUppercase using a while loop
		while((c = reader.read()) != -1) {
			//Write each character toUpperCase()
			writer.write(Character.toUpperCase(c));
		}
		
		//Close reader and writer
		reader.close();
		writer.close();
		
	}

}