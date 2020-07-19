package com.api.busmaster.models;

public class AttendanceRecord {
	// Private attributes
	private int attendanceRecId;
	private String attendanceDt;
	private int riderId;
	
	// Public constructors
	public AttendanceRecord() {}
	
	public AttendanceRecord(int attendanceRecId, String attendanceDt, int riderId) {
		this.attendanceRecId = attendanceRecId;
		this.attendanceDt = attendanceDt;
		this.riderId = riderId;
	}

	// Getters/Setters
	public int getAttendanceRecId() {
		return attendanceRecId;
	}

	public void setAttendanceRecId(int attendanceRecId) {
		this.attendanceRecId = attendanceRecId;
	}

	public String getAttendanceDt() {
		return attendanceDt;
	}

	public void setAttendanceDt(String attendanceDt) {
		this.attendanceDt = attendanceDt;
	}

	public int getRiderId() {
		return riderId;
	}

	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
}
