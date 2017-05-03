package metric;

public class Metric {

    private String metricName;

    private long populateTime;
    private long getTime;
    private long addTime;
    private long containsTime;
    private long removeTime;

    public Metric(String metricName) {
        this.metricName = metricName;
    }

    Metric(long populateTime, long getTime, long addTime, long containsTime, long removeTime) {
        this.populateTime = populateTime;
        this.getTime = getTime;
        this.addTime = addTime;
        this.containsTime = containsTime;
        this.removeTime = removeTime;
    }

    public void setPopulateTime(long populateTime) {
        this.populateTime = populateTime;
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

    public Metric average(Metric otherMetric) {
        Metric averageMetric = new Metric(this.metricName);
        averageMetric.setPopulateTime((this.populateTime + otherMetric.populateTime) / 2);
        averageMetric.setGetTime((this.getTime + otherMetric.getTime) / 2);
        averageMetric.setAddTime((this.addTime + otherMetric.addTime) / 2);
        averageMetric.setContainsTime((this.containsTime + otherMetric.containsTime) / 2);
        averageMetric.setRemoveTime((this.removeTime + otherMetric.removeTime) / 2);
        return averageMetric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metric metric = (Metric) o;

        if (populateTime != metric.populateTime) return false;
        if (getTime != metric.getTime) return false;
        if (addTime != metric.addTime) return false;
        if (containsTime != metric.containsTime) return false;
        if (removeTime != metric.removeTime) return false;
        return metricName.equals(metric.metricName);
    }

    @Override
    public int hashCode() {
        int result = metricName.hashCode();
        result = 31 * result + (int) (populateTime ^ (populateTime >>> 32));
        result = 31 * result + (int) (getTime ^ (getTime >>> 32));
        result = 31 * result + (int) (addTime ^ (addTime >>> 32));
        result = 31 * result + (int) (containsTime ^ (containsTime >>> 32));
        result = 31 * result + (int) (removeTime ^ (removeTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "metricName=" + metricName +
                ", populateTime=" + populateTime +
                ", getTime=" + getTime +
                ", addTime=" + addTime +
                ", containsTime=" + containsTime +
                ", removeTime=" + removeTime;
    }
}
