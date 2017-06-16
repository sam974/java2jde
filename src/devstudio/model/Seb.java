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

	public Activity activityCreate(String task) {
		return Activity.of(projectName, task);
	}

	public Activity activityTesting() {
		return activityCreate(Constants.TASK_TEST);
	}

	public Activity activityDailyMeeting() {
		return activityCreate(Constants.TASK_TEAMMEETING);
	}

	public Activity activityDevel() {
		return activityCreate(Constants.TASK_DEVEL);
	}

	public Day dayCreate(Activity mainActivity, boolean dailyMeeting, boolean halfDayOff) {
		Day out = new Day();
		out.add(mainActivity.allDay());
		if (dailyMeeting) {
			out.add(activityDailyMeeting().during(Constants.WORKLOAD_30min));
		}
		if (halfDayOff) {
			out.add(Activity.DAYOFF.during(Constants.WORKLOAD_HALFDAY));
		}
		return out;
	}

	public Day dayWorkWithWeeklyMeeting() {
		return dayWork().add(Activity.WEEKLY_MEETING.during(Constants.WORKLOAD_1h));
	}

	public Day dayWork() {
		return dayCreate(activityDevel(), true, false);
	}

	public Day dayWorkLegato() {
		return dayCreate(Activity.LEGATO_JAVA, true, false);
	}

	public Day dayTest() {
		return dayCreate(activityTesting(), true, false);
	}

	public Day dayPublicHoliday() {
		return dayCreate(Activity.PUBLICHOLYDAY, false, false);
	}

	public Day dayOff() {
		return dayCreate(Activity.DAYOFF, false, false);
	}
}
