package devstudio.model;

import org.apache.commons.lang3.StringUtils;

public enum Activity {

	ATLANTIS_DEV(Constants.ATLANTIS, Constants.DEVEL),
	ATLANTIS_TEST(Constants.ATLANTIS, Constants.TEST),
	ATLANTIS_DAILY(Constants.ATLANTIS, Constants.DAILY),

	BACCHUS_DEV(Constants.BACCHUS, Constants.DEVEL),
	BACCHUS_TEST(Constants.BACCHUS, Constants.TEST),
	BACCHUS_DAILY(Constants.BACCHUS, Constants.DAILY),

	BAUCIS_DEV(Constants.BAUCIS, Constants.DEVEL),
	BAUCIS_TEST(Constants.BAUCIS, Constants.TEST),
	BAUCIS_DAILY(Constants.BAUCIS, Constants.DAILY),

	LEGACY("legacy", "other"),
	OTHER("misc", "other"),

	DAYOFF("absence", "conge"),
	PUBLICHOLYDAY("absence", "ferie");

	private String project;
	private String task;

	Activity(String projectId, String taskId) {
		this.project = projectId == null ? "" : Config.INSTANCE.getProject(projectId);
		this.task = taskId == null ? "" : Config.INSTANCE.getTask(taskId);
	}

	public String getProject() {
		return project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setProject(String project) {
		this.project = project;
	}

	private static Activity retrieve(String projectName, String task) {
		for (Activity activity : values()) {
			if (StringUtils.equals(Config.INSTANCE.getProject(projectName), activity.project)
					&& StringUtils.equals(activity.task, Config.INSTANCE.getTask(task))) {
				return activity;
			}
		}
		throw new IllegalStateException("Cannot find activity: " + projectName + " / " + task);
	}

	public static Activity getDevel(String projectName) {
		return retrieve(projectName, Constants.DEVEL);
	}

	public static Activity getDaily(String projectName) {
		return retrieve(projectName, Constants.DAILY);
	}

	public static Activity getTest(String projectName) {
		return retrieve(projectName, Constants.TEST);
	}
}
