package com.stephenson.IntroLessonStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/****

<b>Title:</b> FileHandler.java<br>
<b>Project:</b> Intro Programming Homework<br>
<b>Description:</b> <br>
<b>Copyright:</b> Copyright (c) 2023<br>
<b>Company:</b> Silicon Mountain Technologies<br>
@author Cole Stephenson
@version 1.0
@since Jul 31 2023
@updates:

****/

public class FileHandler {
	
	//Folder to be written into with new files
	private File folder;
	
	/**
	 * Constructor for the class
	 * @param folder
	 */
	public FileHandler(File folder) {
		this.folder = folder;
	}

	/**
	 * Getter for the input folder
	 * @return the input folder File member of the class
	 */
	public File getFolder() {
		return folder;
	}
	
	
	/**
	 * Setter for the input folder
	 * @param folder File to be set as the input folder File member of the class
	 */
	public void setFolder(File folder) {
		this.folder = folder;
	}
	
	
	/**
	 * 
	 * @param Input file to be read
	 * @return new FileReader with input file as a param
	 * @throws FileNotFoundException
	 */
	public FileReader readFile(File input) throws FileNotFoundException {
		return new FileReader(input);
	}
	
	/**
	 * A method to stream an input file to an output file
	 * using a FileReader and a FileWriter
	 * @return An output file written within the constructor's folder
	 * @throws IOException
	 */
	public File writeFile() throws IOException {
		
		//Instantiate int for current character in the input file stream
		int c;
		
		//Instantiate a FileWriter with the output file within the folder
		File fileOut = new File(folder + "/output.txt");
		FileWriter writer =	new FileWriter(fileOut);
		
		//Instantiate a FileReader with the input file within the folder
		File fileIn = new File(folder + "/input.txt");
		FileReader reader = readFile(fileIn);
		
		//Stream the input file into the output file with a while loop
		while((c = reader.read()) != -1) {
			writer.write(c);
		}
		
		//Close the Reader and Writer
		reader.close();
		writer.close();
		
		//Return the output file with data streamed in
		return fileOut;
	}
}