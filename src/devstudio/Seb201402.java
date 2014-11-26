package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201402 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.FEBRUARY);
		Seb seb = new Seb(Constants.ATLANTIS);

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting1h(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.test());
		report.newDay(seb.dayOff());
		report.newDay(seb.test());
		report.newDay(seb.dev()).addSubActivity(Activity.SUPPORT_LEGACY, Constants.TWO_HOURS);

		report.newDay(seb.setProjectName(Constants.BACCHUS).dev()).addSubActivity(Activity.ATLANTIS_DAILY, Constants.TWO_HOURS);
		report.newDay(seb.halfDayOff(seb.dev()));
		report.newDay(seb.meeting(seb.dev(), Constants.TWO_HOURS));
		report.newDay(seb.dev());
		report.newDay(seb.halfDayOff(seb.dev()));

		Csv.writeReport(report);
	}
}
