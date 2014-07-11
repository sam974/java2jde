package devstudio.model;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Day {

	public final static Day WEEKEND = new Day();

	/**
	 * Attributes
	 */
	private Activity greedyActivity = null;
	private final Map<Activity, Double> activities = new TreeMap<>();

	public Day() {
	}

	public Day(Activity activity) {
		setGreedyActivity(activity);
	}

	public Day addSubActivity(Activity activity, Double workLoad) {
		assert workLoad != Constants.GREEDY;
		assert workLoad >= Constants.NOTHING;
		Double load = activities.get(activity);
		if (load == null) {
			activities.put(activity, workLoad);
		} else {
			assert load + workLoad <= Constants.FULL_DAY;
			activities.put(activity, load + workLoad);
		}
		getFixedLoad();
		return this;
	}

	public Day removeSubActivity(Activity activity) {
		activities.remove(activity);
		return this;
	}

	public Day removeSubActivity(Activity activity, Double workLoad) {
		Double load = activities.get(activity);
		if (load != null) {
			if (workLoad >= load) {
				activities.remove(activity);
			} else {
				assert load - workLoad >= 0;
				activities.put(activity, load - workLoad);
			}
		}
		return this;
	}

	public Double getFixedLoad() {
		Double out = Constants.NOTHING;
		for (Entry<Activity, Double> e : activities.entrySet()) {
			out += e.getValue();
		}
		assert out <= Constants.FULL_DAY;
		return out;
	}

	public Double getWork(Activity activity) {
		Double out = Constants.NOTHING;
		if (activity == greedyActivity) {
			out = Constants.FULL_DAY - getFixedLoad();
		} else if (activities.containsKey(activity)) {
			out = activities.get(activity);
		}
		return out;
	}

	public Day setGreedyActivity(Activity greedyActivity) {
		this.greedyActivity = greedyActivity;
		return this;
	}
}
