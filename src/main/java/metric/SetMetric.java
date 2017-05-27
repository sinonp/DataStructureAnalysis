package metric;

public class SetMetric implements Metric {

    private String metricName;
    private long addTime;
    private long containsTime;
    private long nextTime;

    public SetMetric(String metricName) {
        this.metricName = metricName;
    }

    SetMetric(String metricName, int addTime, int containsTime, int nextTime) {
        this.metricName = metricName;
        this.addTime = addTime;
        this.containsTime = containsTime;
        this.nextTime = nextTime;

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
        SetMetric otherSetMetric = (SetMetric) otherMetric;
        SetMetric averageMetric = new SetMetric(this.metricName);
        averageMetric.setAddTime((this.addTime + otherSetMetric.addTime) / 2);
        averageMetric.setContainsTime((this.containsTime + otherSetMetric.containsTime) / 2);
        averageMetric.setNextTime((this.nextTime + otherSetMetric.nextTime) / 2);

        return averageMetric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetMetric setMetric = (SetMetric) o;

        return addTime == setMetric.addTime && containsTime == setMetric.containsTime
                && nextTime == setMetric.nextTime && metricName.equals(setMetric.metricName);
    }

    @Override
    public int hashCode() {
        int result = metricName.hashCode();
        result = 31 * result + (int) (addTime ^ (addTime >>> 32));
        result = 31 * result + (int) (containsTime ^ (containsTime >>> 32));
        result = 31 * result + (int) (nextTime ^ (nextTime >>> 32));
        return result;
    }
}
