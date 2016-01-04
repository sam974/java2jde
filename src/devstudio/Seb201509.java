package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201509 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2015, Calendar.SEPTEMBER);
		Seb seb = new Seb(Constants.PROJECT_CONCERTO);

		report.newDay(seb.dev());
		report.newDay(seb.dev()).addSubActivity(Activity.OTHER, Constants.ONE_HOUR);
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dayOff()); // Formation
		report.newDay(seb.dayOff()); // Formation
		report.newDay(seb.dayOff()); // Formation
		report.newDay(seb.dev());
		report.newDay(seb.dayOff());

		report.newDay(seb.halfDayOff(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev()).addSubActivity(Activity.OTHER, Constants.ONE_HOUR);

		Csv.writeReport(report);
	}
}
