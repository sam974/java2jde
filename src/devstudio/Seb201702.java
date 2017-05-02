package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201702 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2017, Calendar.FEBRUARY);
		Seb seb = new Seb(Constants.PROJECT_DISCO);

		report.add(seb.dayWorkWithWeeklyMeeting());
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
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayCreate(Activity.of(Constants.PROJECT_LEGATO, Constants.TASK_LEGATO_JAVA), true, false));
		report.add(seb.dayCreate(Activity.of(Constants.PROJECT_LEGATO, Constants.TASK_LEGATO_JAVA), true, false));
		report.add(seb.dayCreate(Activity.of(Constants.PROJECT_LEGATO, Constants.TASK_LEGATO_JAVA), true, false));
		report.add(seb.dayCreate(Activity.of(Constants.PROJECT_LEGATO, Constants.TASK_LEGATO_JAVA), false, false));

		report.add(seb.dayOff());
		report.add(seb.dayOff());

		Csv.writeReport(report);
	}
}
