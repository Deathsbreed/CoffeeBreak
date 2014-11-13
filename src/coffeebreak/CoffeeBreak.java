package coffeebreak;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class CoffeeBreak {
	public static final String usage = "Usage: coffeebreak [compiler]";
	public String[] compilers = {"gcc", "g++", "clang++", "javac", "ant"};

	public CoffeeBreak(String compiler) {
		int compid = -1;
		compilerLoop:
		for(int i = 0; i < compilers.length; i++) {
			if(compiler.equals(compilers[i])) {
				compid = i;
				break compilerLoop;
			}
		}
		if(compid == -1) {
			System.out.println("This compiler is not supported. Add it!!!");
			return;
		}
		System.out.println("You chose compiler " + compiler);
	}

	public void compileGCC() {

	}

	public void compileGXX() {

	}

	public void compileCLANGXX() {

	}

	public void compileJAVAC() {

	}

	public void compileANT() {

	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Invalid number of arguments.\n" + usage);
			return;
		}
		new CoffeeBreak(args[0]);
	}
}
