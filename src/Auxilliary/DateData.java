package Auxilliary;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateData {
	public static String getDate() {
		LocalDate currentDate = LocalDate.now();
        // Define a format (e.g., dd/MM/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convert LocalDate to String
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
		
	}
}
