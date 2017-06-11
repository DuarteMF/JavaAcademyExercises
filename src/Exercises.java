public class Exercises {

	public static void main(String[] args) {
		System.out.println(russianMultiplication(57,86));
		System.out.println(capitalizeFirstLetterWords("Hello, my fellow students"));

	}
	
	
	/**
	 * This is the answer to number one, how to do Russian Multiplication.
	 * Separate 2 numbers into two columns, and add 'lines' by doubling number 1 and halving number 2 (up to the floor value).
	 * If a line contains an even number 2, erase that line.
	 * Stop once number 2 is 1, and then add all of the number 1 from all none erased lines.
	 * This works recursively, once number 2 is 1 simply return out the value of number 1, besides that, if number 2 is 
	 * even simply calculate the next line without caring for the current line's number 1, other wise simply add number 1 to 
	 * result of next line.
	 * @param number1 first number, the ones to be added
	 * @param number2 second number, where we keep track whether to delete the line and when to stop
	 * @return final result
	 */
	public static int russianMultiplication(int number1, int number2){
		if(number2==1){
			return number1;
		}
		if(Math.floorMod(number2, 2)==1){
			return number1 + russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}else{
			return russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}
	}
	
	public static String capitalizeFirstLetterWords(String text){
		String[] words = text.split("\\s+");
		for(int i = 0; i < words.length; i++){
			words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
		}
		return String.join(" ", words);
	}

}
