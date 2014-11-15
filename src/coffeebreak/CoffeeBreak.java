package coffeebreak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 * Description: A program to quick get out of working for a few minutes.
 * 
 */
public class CoffeeBreak {
	private static final String version = "v0.1";
	private static final String usage = "Usage: coffeebreak [-h | --help | -v | -c | -w | -f <file>]";

	// Constructor:
	public CoffeeBreak(String filepath) {
		String line;
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(filepath));
				try {
					while((line = br.readLine()) != null) {
						System.out.println(line);
						try {
							Thread.sleep(2000);
						} catch(InterruptedException e) { System.out.println("Error waiting."); }
					}
					br.close();
				} catch(IOException e) {
					System.out.println("Error with reading from file.");
					System.exit(1);
				}
			} catch(FileNotFoundException e) {
				System.out.println("Cannot find file.");
				System.exit(1);
			}
		}
	}

	// Main:
	public static void main(String[] args) {
		if(args.length == 2) {
			if(args[0].equals("-f")) new CoffeeBreak(args[1]);
			else System.out.println("Invalid argument '" + args[0] + "'.\n" + usage);
		} else if(args.length == 1) {
			if(args[0].equals("-h") || args[0].equals("--help")) printHelpInfo();
			else if(args[0].equals("-v")) System.out.println("CoffeeBreak " + version);
			else if(args[0].equals("-c")) printCopyrightInfo();
			else if(args[0].equals("-w")) printWarrantyInfo();
			else System.out.println("Invalid argument '" + args[0] + "'.\n" + usage);
		} else {
			System.out.println("Invalid number of arguments.");
			return;
		}
	}

	private static void printHelpInfo() {
		System.out.println(usage +
			"\n -h or --help  -- Print this help information." +
			"\n -v            -- Print version." +
			"\n -c            -- Print copyright information." +
			"\n -w            -- Print warranty information." +
			"\n -f <file>     -- File to read from.");
	}

	private static void printCopyrightInfo() {
		// TODO
	}

	private static void printWarrantyInfo() {
		// TODO
	}
}
