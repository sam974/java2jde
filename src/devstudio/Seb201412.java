package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.Day;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201412 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.DECEMBER);
		Seb seb = new Seb(Constants.BRONTES);

		report.newDay(seb.dev()).addSubActivity(Activity.DAYOFF, Constants.HALF_DAY);
		report.newDay(seb.dev());
		report.newDay(seb.meeting1h(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(new Day(Activity.OTHER));

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.HALF_DAY);
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.HALF_DAY);
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.HALF_DAY);
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.TWO_HOURS);
		report.newDay(seb.dev());

		report.newDay(seb.noDaily(seb.dev())).addSubActivity(Activity.DAYOFF, Constants.HALF_DAY);
		report.newDay(seb.noDaily(seb.dev())).addSubActivity(Activity.DAYOFF, Constants.HALF_DAY);
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		Csv.writeReport(report);
	}
}
