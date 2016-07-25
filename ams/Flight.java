package ams;

import java.sql.Date;

public class Flight {
	private String id;
	private String name;
	private String departure;
	private String arrival;
	private String planeid;
	private String vac_f;
	private String vac_b;
	private String vac_e;
	private String fare_f;
        private String fare_b;
        private String fare_e;
	private String basic_cost;
	private String bookinglist;
	private String routeid;
	/**
	 * @return the id
	 */
        public Flight(){
            
        }
       public void setId(String t){
           id = t;
       }
	public String getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the planeid
	 */
	public String getPlaneid() {
		return planeid;
	}
	/**
	 * @param planeid the planeid to set
	 */
	public void setPlaneid(String planeid) {
		this.planeid = planeid;
	}
	/**
	 * @return the vac_f
	 */
	public String getVac_f() {
		return vac_f;
	}
	/**
	 * @param vac_f the vac_f to set
	 */
	public void setVac_f(String vac_f) {
		this.vac_f = vac_f;
	}
	/**
	 * @return the vac_b
	 */
	public String getVac_b() {
		return vac_b;
	}
	/**
	 * @param vac_b the vac_b to set
	 */
	public void setVac_b(String vac_b) {
		this.vac_b = vac_b;
	}
	/**
	 * @return the vac_e
	 */
	public String getVac_e() {
		return vac_e;
	}
	/**
	 * @param vac_e the vac_e to set
	 */
	public void setVac_e(String vac_e) {
		this.vac_e = vac_e;
	}
	/**
	 * @return the fare
	 */
	public String getFare_f() {
		return fare_f;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare_f(String fare) {
		this.fare_f = fare;
	}
        public String getFare_b() {
		return fare_b;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare_b(String fare) {
		this.fare_b = fare;
	}
        
        public String getFare_e() {
		return fare_e;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare_e(String fare) {
		this.fare_e = fare;
	}
	/**
	 * @return the basic_cost
	 */
	public String getBasic_cost() {
		return basic_cost;
	}
	/**
	 * @param basic_cost the basic_cost to set
	 */
	public void setBasic_cost(String basic_cost) {
		this.basic_cost = basic_cost;
	}
	/**
	 * @return the bookinglist
	 */
	public String getBookinglist() {
		return bookinglist;
	}
	/**
	 * @param bookinglist the bookinglist to set
	 */
	public void setBookinglist(String bookinglist) {
		this.bookinglist = bookinglist;
	}
	/**
	 * @return the routeid
	 */
	public String getRouteid() {
		return routeid;
	}
	/**
	 * @param routeid the routeid to set
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	
}
