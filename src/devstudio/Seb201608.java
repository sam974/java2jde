package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201608 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.AUGUST);
		Seb seb = new Seb(Constants.PROJECT_DIAPASON);

		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		report.add(seb.dayPublicHoliday());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());

		Csv.writeReport(report);
	}
}
