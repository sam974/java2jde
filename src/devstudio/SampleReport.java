package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class SampleReport {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.JANUARY);
		Seb seb = new Seb(Constants.ATLANTIS);

		report.newDay(seb.publicHoliday());
		report.newDay(seb.dayOff());
		report.newDay(seb.dayOff());

		report.newDay(seb.dev());
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.test());
		report.newDay(seb.noDaily(seb.test()));
		report.newDay(seb.setProjectName(Constants.BACCHUS).dev());

		report.newDay(seb.halfDayOff(seb.dev()));
		report.newDay(seb.halfDayOff(seb.noDaily(seb.dev())));
		report.newDay(seb.halfDayOff(seb.noDaily(seb.test())));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev()).addSubActivity(Activity.LEGACY, Constants.ONE_HOUR);
		report.newDay(seb.dev()).addSubActivity(Activity.OTHER, Constants.TWO_HOURS);
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
