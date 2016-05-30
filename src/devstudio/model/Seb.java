package devstudio.model;

public class Seb {

	private String projectName;

	public Seb(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public Seb setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public Activity createActivity(String task) {
		return Activity.of(projectName, task);
	}

	public Activity testing() {
		return createActivity(Constants.TASK_TEST);
	}

	public Activity dailyMeeting() {
		return createActivity(Constants.TASK_TEAMMEETING);
	}

	public Activity devel() {
		return createActivity(Constants.TASK_DEVEL);
	}

	public Day newDay(Activity mainActivity, boolean dailyMeeting, boolean halfDayOff) {
		Day out = new Day();
		out.add(mainActivity.allDay());
		if (dailyMeeting) {
			out.add(dailyMeeting().during(Constants.WORKLOAD_30min));
		}
		if (halfDayOff) {
			out.add(Activity.DAYOFF.during(Constants.WORKLOAD_HALFDAY));
		}
		return out;
	}

	public Day workDayWithWeeklyMeeting() {
		return newDay(devel(), true, false).add(Activity.WEEKLY_MEETING.during(Constants.WORKLOAD_1h));
	}

	public Day workDay() {
		return newDay(devel(), true, false);
	}

	public Day testDay() {
		return newDay(testing(), true, false);
	}

	public Day publicHoliday() {
		return newDay(devel(), false, false);
	}

	public Day dayOff() {
		return newDay(devel(), false, false);
	}
}
