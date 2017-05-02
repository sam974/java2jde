package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201703 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2017, Calendar.MARCH);
		Seb seb = new Seb(Constants.PROJECT_DISCO);

		report.add(seb.dayOff());
		report.add(seb.dayOff());
		report.add(seb.dayOff());

		report.add(seb.dayOff());
		report.add(seb.dayCreate(seb.activityDevel(), true, true));
		report.add(seb.dayWork());
		report.add(seb.dayCreate(seb.activityDevel(), true, true));
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
		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWork());

		Csv.writeReport(report);
	}
}
