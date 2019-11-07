package com.train.path;

public class PathInLine {
	private Station start;
	private Station destination;
	private float fare;
	private String remark;

	public PathInLine(Station start, Station destination, int fare, String remark) {
		super();
		this.start = start;
		this.destination = destination;
		this.fare = fare;
		this.remark = remark;
	}

	public Station getStart() {
		return start;
	}

	public void setStart(Station start) {
		this.start = start;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public float getFare() {
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
