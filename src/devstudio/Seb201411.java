package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201411 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.NOVEMBER);
		Seb seb = new Seb(Constants.PROJECT_BRONTES);

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);
		report.newDay(seb.dev());
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);
		report.newDay(seb.dev());
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);

		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.TWO_HOURS);
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);
		report.newDay(seb.meeting1h(seb.dev())).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
