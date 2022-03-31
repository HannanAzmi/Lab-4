public class TextGenerator {

public String getTextLength() {
		
		String text = "My name is Nur Aqilah Hannan. I am 21 years old.";
		String length = String.valueOf(count(text));
		
		return length;
		
	}

	public static int count(String text) {
	
		if(text == null || text.isEmpty()) {
			return 0;
		}
		
		String [] word = text.split("\\s+");
		return word.length;
	}

}
