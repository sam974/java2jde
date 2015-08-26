package devstudio.model;

import org.apache.commons.lang3.StringUtils;

public enum Activity {

	ATLANTIS_DEV(Constants.PROJECT_ATLANTIS, Constants.TASK_DEVEL),
	ATLANTIS_TEST(Constants.PROJECT_ATLANTIS, Constants.TASK_TEST),
	ATLANTIS_DAILY(Constants.PROJECT_ATLANTIS, Constants.TASK_MISC),

	BACCHUS_DEV(Constants.PROJECT_BACCHUS, Constants.TASK_DEVEL),
	BACCHUS_TEST(Constants.PROJECT_BACCHUS, Constants.TASK_TEST),
	BACCHUS_DAILY(Constants.PROJECT_BACCHUS, Constants.TASK_MISC),

	BAUCIS_DEV(Constants.PROJECT_BAUCIS, Constants.TASK_DEVEL),
	BAUCIS_TEST(Constants.PROJECT_BAUCIS, Constants.TASK_TEST),
	BAUCIS_DAILY(Constants.PROJECT_BAUCIS, Constants.TASK_MISC),

	BRONTES_DEV(Constants.PROJECT_BRONTES, Constants.TASK_DEVEL),
	BRONTES_TEST(Constants.PROJECT_BRONTES, Constants.TASK_TEST),
	BRONTES_DAILY(Constants.PROJECT_BRONTES, Constants.TASK_MISC),

	CALYPSO_DEV(Constants.PROJECT_CALYPSO, Constants.TASK_DEVEL),
	CALYPSO_TEST(Constants.PROJECT_CALYPSO, Constants.TASK_TEST),
	CALYPSO_DAILY(Constants.PROJECT_CALYPSO, Constants.TASK_MISC),

	CASSANDRA_DEV(Constants.PROJECT_CASSANDRA, Constants.TASK_DEVEL),
	CASSANDRA_TEST(Constants.PROJECT_CASSANDRA, Constants.TASK_TEST),
	CASSANDRA_DAILY(Constants.PROJECT_CASSANDRA, Constants.TASK_MISC),

	CONCERTO_DEV(Constants.PROJECT_CONCERTO, Constants.TASK_DEVEL),
	CONCERTO_TEST(Constants.PROJECT_CONCERTO, Constants.TASK_TEST),
	CONCERTO_DAILY(Constants.PROJECT_CONCERTO, Constants.TASK_MISC),

	SUPPORT_LEGACY(Constants.PROJECT_LEGACY, Constants.TASK_OTHER),
	OTHER(Constants.PROJECT_MISC, Constants.TASK_OTHER),

	DAYOFF(Constants.PROJECT_ABSENCE, Constants.TASK_CONGE),
	PUBLICHOLYDAY(Constants.PROJECT_ABSENCE, Constants.TASK_FERIE);

	private String project;
	private String task;

	Activity(String projectId, String taskId) {
		assert StringUtils.isNotBlank(projectId);
		assert StringUtils.isNotBlank(taskId);
		this.project = projectId;
		this.task = taskId;
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
			if (StringUtils.equals(activity.project, projectName) && StringUtils.equals(activity.task, task)) {
				return activity;
			}
		}
		throw new IllegalStateException("Cannot find activity: " + projectName + " / " + task);
	}

	public static Activity getDevel(String projectName) {
		return retrieve(projectName, Constants.TASK_DEVEL);
	}

	public static Activity getDaily(String projectName) {
		return retrieve(projectName, Constants.TASK_MISC);
	}

	public static Activity getTest(String projectName) {
		return retrieve(projectName, Constants.TASK_TEST);
	}
}
