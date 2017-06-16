package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201705 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2017, Calendar.MAY);
		Seb seb = new Seb(Constants.PROJECT_ELECTRO);

		report.add(seb.dayPublicHoliday());
		report.add(seb.dayCreate(seb.activityDevel(), true, true));
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());

		report.add(seb.dayPublicHoliday());
		report.add(seb.dayWork());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());

		report.add(seb.dayWork());
		report.add(seb.dayWork());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());

		report.add(seb.dayWork());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayWorkLegato());
		report.add(seb.dayPublicHoliday());
		report.add(seb.dayOff());

		report.add(seb.dayWork());
		report.add(seb.dayCreate(Activity.LEGATO_JAVA, true, true));
		report.add(seb.dayWorkLegato());

		Csv.writeReport(report);
	}
}
