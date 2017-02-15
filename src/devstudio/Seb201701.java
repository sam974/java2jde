package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201701 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2017, Calendar.JANUARY);
		Seb seb = new Seb(Constants.PROJECT_DISCO);

		report.add(seb.dayOff());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayCreate(seb.activityDevel(), false, false));
		report.add(seb.dayCreate(seb.activityDevel(), false, false));
		report.add(seb.dayCreate(seb.activityDevel(), false, false));
		report.add(seb.dayCreate(seb.activityDevel(), false, false));
		report.add(seb.dayCreate(seb.activityDevel(), false, false));

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());

		Csv.writeReport(report);
	}
}
