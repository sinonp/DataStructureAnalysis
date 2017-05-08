package metric;

public class SetMetric implements Metric {

    private String metricName;
    private long addTime;
    private long containsTime;
    private long nextTime;

    public SetMetric(String metricName) {
        this.metricName = metricName;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public void setContainsTime(long containsTime) {
        this.containsTime = containsTime;
    }

    public void setNextTime(long nextTime) {
        this.nextTime = nextTime;
    }

    public String getMetricName() {
        return metricName;
    }

    public long getAddTime() {
        return addTime;
    }

    public long getContainsTime() {
        return containsTime;
    }

    public long getNextTime() {
        return nextTime;
    }

    @Override
    public Metric average(Metric otherMetric) {
        return null;
    }
}
