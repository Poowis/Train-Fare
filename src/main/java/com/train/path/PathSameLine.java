package com.train.path;

public class PathSameLine {
	private String start;
	private String destination;
	private int fare;
	private String remark;

	public PathSameLine(String start, String destination, int fare, String remark) {
		super();
		this.start = start;
		this.destination = destination;
		this.fare = fare;
		this.remark = remark;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return start + " -> " + destination + " : " + fare + " ***" + remark + "***";
	}
}
