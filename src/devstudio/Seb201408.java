package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201408 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.AUGUST);
		Seb seb = new Seb(Constants.BAUCIS);

		report.newDay(seb.dev());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.publicHoliday());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting1h(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
