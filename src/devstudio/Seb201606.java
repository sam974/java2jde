package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201606 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.JUNE);
		Seb seb = new Seb(Constants.PROJECT_DEBUSSY);

		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayCreate(Activity.WEEKLY_MEETING, false, false)); // Innovation Summit
		report.add(seb.dayCreate(Activity.WEEKLY_MEETING, false, false)); // Innovation Summit
		seb.setProjectName(Constants.PROJECT_DIAPASON);
		report.add(seb.dayCreate(seb.activityDevel(), false, false).add(Activity.WEEKLY_MEETING.during(Constants.WORKLOAD_4h))); // Innovation Summit
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		Csv.writeReport(report);
	}
}
