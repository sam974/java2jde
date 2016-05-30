package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201604 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.APRIL);
		Seb seb = new Seb(Constants.PROJECT_DEBUSSY);

		report.add(seb.workDay());

		report.add(seb.workDay());
		report.add(seb.workDay());
		report.add(seb.workDayWithWeeklyMeeting());
		report.add(seb.workDay());
		report.add(seb.workDay());

		report.add(seb.workDay());
		report.add(seb.workDay());
		report.add(seb.workDayWithWeeklyMeeting());
		report.add(seb.workDay());
		report.add(seb.workDay());

		report.add(seb.workDay());
		report.add(seb.workDay());
		report.add(seb.workDayWithWeeklyMeeting());
		report.add(seb.workDay());
		report.add(seb.dayOff());

		report.add(seb.dayOff());
		report.add(seb.workDay());
		report.add(seb.workDayWithWeeklyMeeting());
		report.add(seb.workDay());
		report.add(seb.workDay());

		Csv.writeReport(report);
	}
}
