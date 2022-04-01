package tcpserverTranslation;

/*
 * This class is to translate the input text to respective language
 * 
 * @author Hannan
 * 
 */

public class ServerTranslator {
	private String output;
	
	public String translate(String engText, int language) {
		
		if(language == 1) {
			//Bahasa Malaysia
			switch (engText) {
            case "Good morning":
                output = "Selamat pagi";
                break;
            case "Good night":
            	output = "Selamat malam";
                break;
            case "How are you?":
            	output = "Apa khabar?";
                break;
            case "Thank you":
            	output = "Terima kasih";
                break;
            case "Goodbye":
            	output = "Selamat tinggal";
                break;
            case "What's up?":
            	output = "Ada apa?";
                break;
			}
		}
		else if(language == 2) {
			//Arabic
			switch (engText) {
            case "Good morning":
            	output = "صباح الخير";
                break;
            case "Good night":
            	output = "طاب مساؤك";
                break;
            case "How are you?":
            	output = "كيف حالك؟";
                break;
            case "Thank you":
            	output = "شكرا لك";
                break;
            case "Goodbye":
            	output = "مع السلامة";
                break;
            case "What's up?":
            	output = "ما أخبارك؟";
                break;
			}
		}
		else if(language == 3) {
			//Korean
			 switch (engText) {
             case "Good morning":
            	 output = "좋은 아침";
                 break;
             case "Good night":
            	 output = "안녕히 주무세요";
                 break;
             case "How are you?":
            	 output = "어떻게 지내세요?";
                 break;
             case "Thank you":
            	 output = "감사합니다";
                 break;
             case "Goodbye":
            	 output = "안녕";
                 break;
             case "What's up?":
            	 output = "뭐야?";
                 break;
			}
		}
		
		return output;
	}
}