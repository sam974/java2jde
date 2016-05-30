package devstudio.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Day {

	public final static Day WEEKEND = new Day();

	private final Map<Activity, Double> activities = new HashMap<>();

	public Day() {
	}

	public Day add(Pair<Activity, Double> p) {
		if (p.getValue() == Constants.WORKLOAD_GREEDY) {
			activities.entrySet().removeIf(e -> e.getValue() == Constants.WORKLOAD_GREEDY);
			activities.put(p.getKey(), p.getValue());
		} else if (p.getValue() > Constants.WORKLOAD_NOTHING) {
			if (activities.containsKey(p.getKey())) {
				if (activities.get(p.getKey()) != Constants.WORKLOAD_GREEDY) {
					activities.put(p.getKey(), activities.get(p.getKey()) + p.getValue());
				}
			} else {
				activities.put(p.getKey(), p.getValue());
			}
		}
		getFixedLoad();
		return this;
	}

	public Day removeSubActivity(Activity activity) {
		activities.remove(activity);
		return this;
	}

	public Day removeSubActivity(Pair<Activity, Double> activity) {
		Double load = activities.get(activity);
		if (load != null && load != Constants.WORKLOAD_GREEDY) {
			if (activity.getValue() >= load) {
				activities.remove(activity.getKey());
			} else {
				activities.put(activity.getKey(), load - activity.getValue());
			}
		}
		return this;
	}

	public Double getFixedLoad() {
		double out = activities.entrySet().stream().filter(a -> a.getValue() != Constants.WORKLOAD_GREEDY)
				.collect(Collectors.summarizingDouble(Map.Entry::getValue)).getSum();
		assert out >= Constants.WORKLOAD_NOTHING;
		assert out <= Constants.WORKLOAD_FULLDAY;
		return out;
	}

	public Double getWork(Activity activity) {
		Double out = activities.get(activity);
		if (out == null) {
			out = Constants.WORKLOAD_NOTHING;
		} else if (out == Constants.WORKLOAD_GREEDY) {
			out = Constants.WORKLOAD_FULLDAY - getFixedLoad();
		}
		assert out >= 0;
		assert out <= Constants.WORKLOAD_FULLDAY;
		return out;
	}

	public Set<Activity> getActivities() {
		return activities.keySet();
	}
}
