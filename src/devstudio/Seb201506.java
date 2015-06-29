package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.Day;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201506 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2015, Calendar.JUNE);
		Seb seb = new Seb(Constants.PROJECT_CASSANDRA);

		report.newDay(seb.publicHoliday());

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
		report.newDay(seb.dev());
		report.newDay(new Day(Activity.OTHER)); // Innovation Summit
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
