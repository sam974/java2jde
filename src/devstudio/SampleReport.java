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
		Seb seb = new Seb(Constants.PROJECT_ATLANTIS);

		report.add(seb.dayPublicHoliday());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkWithWeeklyMeeting());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		report.add(seb.dayWork());
		report.add(seb.dayTest());
		report.add(seb.dayCreate(seb.activityTesting(), false, true)); // testing, 1/2 journée, daily
		report.add(seb.dayCreate(seb.activityTesting(), true, true)); // testing, 1/2 journée, no daily
		report.add(seb.setProjectName(Constants.PROJECT_BACCHUS).dayWork()); // change project

		report.add(seb.dayWork().add(Activity.SUPPORT_LEGACY.during(Constants.WORKLOAD_1h)));
		report.add(seb.dayWork().add(Activity.OTHER.during(Constants.WORKLOAD_2h)));
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		Csv.writeReport(report);
	}
}
