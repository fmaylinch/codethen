package samples.dates;

import org.joda.time.LocalDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Example of using {@link Date}, {@link DateFormat} and {@link Calendar}.
 *
 * We also show {@link LocalDateTime} (from joda-time library instead of java.time)
 * because it's quite popular and a bit easier to use. http://www.joda.org/joda-time
 */
public class DatesSample {

	public static void main(String[] args) throws Exception {

		System.out.println("--- Date and DateFormat to create and format dates ---");

		// Date holds an instant in time
		Date date = new Date(); // Date from current computer time
		System.out.println("Current date: " + date);
		System.out.println("Current millis: " + date.getTime()); // from 1-1-1970 at GMT

		// DateFormat formats dates in a readable format
		// SimpleDateFormat is a DateFormat that lets you choose the date pattern
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateStr = dateFormat.format(date);
		System.out.println("Current date (formatted): " + dateStr);

		// You can also set the TimeZone and the Locale (country/language)
		// We'll set time zone of Los Angeles (PDT) and Spanish locale
		DateFormat dateFormat2 = new SimpleDateFormat("dd MMMM yyyy", new Locale("es")); // MMMM for long month word
		dateFormat2.setTimeZone(TimeZone.getTimeZone("PDT"));
		System.out.println("Current date in Los Angeles (formatted): " + dateFormat2.format(date));

		// With DateFormat you can also parse a String and get a Date
		Date birthDate = dateFormat.parse("21-09-1978 09:30:00");



		System.out.println("--- Calendar or LocalDateTime to modify dates ---");

		// With Calendar you can modify dates (you shouldn't use Date directly for altering a date)
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		calendar.add(Calendar.MONTH, 2);
		Date modifiedDate = calendar.getTime();
		System.out.println( "Modified date (using calendar): " + dateFormat.format(modifiedDate) );

		// LocalDateTime (from joda-time library) provide easier methods (and can be chained)
		Date modifiedDate2 = new LocalDateTime(birthDate).withYear(2017).withDayOfMonth(25).plusMonths(2).toDate();
		System.out.println( "Modified date (using joda-time): " + dateFormat.format(modifiedDate2) );
	}
}
