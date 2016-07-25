/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

/**
 *
 * @author ritz619
 */

public class Booking {
	private int id;
	private int seatno;
	private String Clss;
	private int fare;
	private char status;
	private int userid;
	private int flightid;
	
	/**
	 * @return the clss
	 */
        
        public void setId(int id) {
            this.id = id;
        }
	public String getClss() {
		return Clss;
	}
	/**
	 * @param clss the clss to set
	 */
	public void setClss(String clss) {
		Clss = clss;
	}
	/**
	 * @return the fare
	 */
	public int getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(int fare) {
		this.fare = fare;
	}
	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the flightid
	 */
	public int getFlightid() {
		return flightid;
	}
	/**
	 * @param flightid the flightid to set
	 */
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
//	public void setId(int id) {
//		this.id = id;
//	}
	/**
	 * @return the seatno
	 */
	public int getSeatno() {
		return seatno;
	}
	/**
	 * @param seatno the seatno to set
	 */
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
}
