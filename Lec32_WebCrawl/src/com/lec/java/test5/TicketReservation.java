package com.lec.java.test5;

import java.util.Date;

class TicketReservation {
	int uid;
	int movieId;
	int seatId;
	Date regDate;
	
	public TicketReservation() {}

	public TicketReservation(int uid, int movieId, int seatId, Date regDate) {
		this.uid = uid;
		this.movieId = movieId;
		this.seatId = seatId;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
}
