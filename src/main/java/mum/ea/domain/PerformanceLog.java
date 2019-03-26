package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Entity;

@Entity
public class PerformanceLog extends BaseDomain {

    private long time;
    private String method;


    public PerformanceLog() {
    }

    public PerformanceLog(long time, String method) {
        this.time = time;
        this.method = method;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
