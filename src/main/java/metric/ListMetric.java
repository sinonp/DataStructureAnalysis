package metric;

public class ListMetric implements Metric {

    private String metricName;

    private long getTime;
    private long addTime;
    private long containsTime;
    private long removeTime;

    public ListMetric(String metricName) {
        this.metricName = metricName;
    }

    ListMetric(String metricName, long getTime, long addTime, long containsTime, long removeTime) {
        this.metricName = metricName;
        this.getTime = getTime;
        this.addTime = addTime;
        this.containsTime = containsTime;
        this.removeTime = removeTime;
    }

    public void setGetTime(long getTime) {
        this.getTime = getTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public void setContainsTime(long containsTime) {
        this.containsTime = containsTime;
    }

    public void setRemoveTime(long removeTime) {
        this.removeTime = removeTime;
    }

    public String getMetricName() {
        return metricName;
    }

    public long getGetTime() {
        return getTime;
    }

    public long getAddTime() {
        return addTime;
    }

    public long getContainsTime() {
        return containsTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    @Override
    public Metric average(Metric otherMetric) {
        ListMetric otherListMetric = (ListMetric) otherMetric;
        ListMetric averageMetric = new ListMetric(this.metricName);
        averageMetric.setGetTime((this.getTime + otherListMetric.getTime) / 2);
        averageMetric.setAddTime((this.addTime + otherListMetric.addTime) / 2);
        averageMetric.setContainsTime((this.containsTime + otherListMetric.containsTime) / 2);
        averageMetric.setRemoveTime((this.removeTime + otherListMetric.removeTime) / 2);

        return averageMetric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListMetric metric = (ListMetric) o;

        return getTime == metric.getTime && addTime == metric.addTime && containsTime == metric.containsTime
                && removeTime == metric.removeTime && metricName.equals(metric.metricName);
    }

    @Override
    public int hashCode() {
        int result = metricName.hashCode();
        result = 31 * result + (int) (getTime ^ (getTime >>> 32));
        result = 31 * result + (int) (addTime ^ (addTime >>> 32));
        result = 31 * result + (int) (containsTime ^ (containsTime >>> 32));
        result = 31 * result + (int) (removeTime ^ (removeTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "metricName=" + metricName +
                ", getTime=" + getTime +
                ", addTime=" + addTime +
                ", containsTime=" + containsTime +
                ", removeTime=" + removeTime;
    }
}
