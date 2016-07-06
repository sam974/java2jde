package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201605 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.MAY);
		Seb seb = new Seb(Constants.PROJECT_DEBUSSY);

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

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayCreate(seb.activityCreate(Constants.TASK_TRAVEL), false, false)
				.add(seb.activityCreate(Constants.TASK_SUPPORT).during(Constants.WORKLOAD_4h)));
		report.add(seb.dayWork().add(seb.activityCreate(Constants.TASK_TRAVEL).during(Constants.WORKLOAD_4h + Constants.WORKLOAD_2h)));
		report.add(seb.dayWork());

		report.add(seb.dayWork());

		Csv.writeReport(report);
	}
}
