package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201612 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.DECEMBER);
		Seb seb = new Seb(Constants.PROJECT_DIAPASON);

		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayTest().add(Activity.WEEKLY_MEETING.during(Constants.WORKLOAD_1h)));
		report.add(seb.dayTest());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		seb.setProjectName(Constants.PROJECT_DISCO);
		report.add(seb.dayWork());
		report.add(seb.dayOff());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		report.add(seb.dayOff());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayOff());

		Csv.writeReport(report);
	}
}
