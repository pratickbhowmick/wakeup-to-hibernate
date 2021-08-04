import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {

	public static void main(String[] args) {
		String lang = "en";
		String country = "US";

		Locale l = new Locale(lang, country);
		ResourceBundle rb = ResourceBundle.getBundle("locale", l);
		
		String msg = rb.getString("greeting");
		System.out.println(msg);
		
	}

}
