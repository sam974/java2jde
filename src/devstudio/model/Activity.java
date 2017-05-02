package devstudio.model;

import org.apache.commons.lang3.tuple.Pair;

public class Activity implements Comparable<Activity> {

	public static final Activity DAYOFF = new Activity(Constants.PROJECT_ABSENCE, Constants.TASK_CONGE);
	public static final Activity PUBLICHOLYDAY = new Activity(Constants.PROJECT_ABSENCE, Constants.TASK_FERIE);

	public static final Activity WEEKLY_MEETING = new Activity(Constants.PROJECT_MISC, Constants.TASK_OTHER);
	public static final Activity OTHER = new Activity(Constants.PROJECT_MISC, Constants.TASK_OTHER);
	public static final Activity SUPPORT_LEGACY = new Activity(Constants.PROJECT_LEGACY, Constants.TASK_OTHER);

	public static final Activity LEGATO_JAVA = new Activity(Constants.PROJECT_LEGATO, Constants.TASK_LEGATO_JAVA);

	public static Activity of(String project, String task) {
		return new Activity(project, task);
	}

	private final String project;
	private final String task;

	private Activity(String projectId, String taskId) {
		this.project = projectId;
		this.task = taskId;
	}

	public String getProject() {
		return project;
	}

	public String getTask() {
		return task;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}

	@Override
	public int compareTo(Activity o) {
		int out = project.compareTo(o.project);
		if (out == 0) {
			out = task.compareTo(o.task);
		}
		return out;
	}

	public Pair<Activity, Double> during(Double workload) {
		return Pair.of(this, workload);
	}

	public Pair<Activity, Double> allDay() {
		return Pair.of(this, Constants.WORKLOAD_GREEDY);
	}

}
