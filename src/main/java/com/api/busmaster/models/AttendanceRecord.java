package com.api.busmaster.models;

import java.time.Instant;

public class AttendanceRecord {
	// Private attributes
	private int attendanceRecId;
	private Instant attendanceDt;
	private int riderId;
	
	// Public constructors
	public AttendanceRecord() {}
	
	public AttendanceRecord(int attendanceRecId, Instant attendanceDt, int riderId) {
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

	public Instant getAttendanceDt() {
		return attendanceDt;
	}

	public void setAttendanceDt(Instant attendanceDt) {
		this.attendanceDt = attendanceDt;
	}

	public int getRiderId() {
		return riderId;
	}

	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
}
