package devstudio.model;
public enum Activity {

	ATLANTIS_DEV("atlantis", "dev"),
	ATLANTIS_TEST("atlantis", "test"),
	ATLANTIS_MISC("atlantis", "misc"),

	BACCHUS_DEV("bacchus", "dev"),
	BACCHUS_TEST("bacchus", "test"),
	BACCHUS_MISC("bacchus", "misc"),

	LEGACY("legacy", "other"),
	OTHER("misc", "other"),

	CONGE("absence", "conge"),
	FERIE("absence", "ferie");

	public final static int WORK_GREEDY = -1;

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
}
