package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201601 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.JANUARY);
		Seb seb = new Seb(Constants.PROJECT_CORNAMUSE);

		report.newDay(seb.publicHoliday());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.dev());
		report.newDay(seb.halfDayOff(seb.dev()));

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}