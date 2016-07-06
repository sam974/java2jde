package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201607 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.JULY);
		Seb seb = new Seb(Constants.PROJECT_DIAPASON);

		report.add(seb.dayOff());

		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayWork().add(Activity.DAYOFF.during(Constants.WORKLOAD_HALFDAY)));
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayPublicHoliday());
		report.add(seb.dayOff());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		Csv.writeReport(report);
	}
}
