package ams;

import java.sql.*;


public class Plane {
	private int id;
	private String name;
	private int capacity_f;
	private int capacity_b;
	private int capacity_e;
	private int cost_per_km;
	private String flightlist;
        public Plane(int i, String nam,  String fltlst, int cap_f, int cap_b, int cap_e, int cost_pr ){
            name = new String();
            flightlist = new String();
            capacity_b = cap_b;
            capacity_e = cap_e;
            capacity_f = cap_f;
            cost_per_km = cost_pr;
            id = i;
        }
        
        public String getLocation(Connection con, Date d){
            String str = new String();
            
            return str;
        }
	/**
	 * @return the id
	 */
	public int getId() {
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
	 * @return the capacity_f
	 */
	public int getCapacity_f() {
		return capacity_f;
	}
	/**
	 * @param capacity_f the capacity_f to set
	 */
	public void setCapacity_f(int capacity_f) {
		this.capacity_f = capacity_f;
	}
	/**
	 * @return the capacity_b
	 */
	public int getCapacity_b() {
		return capacity_b;
	}
	/**
	 * @param capacity_b the capacity_b to set
	 */
	public void setCapacity_b(int capacity_b) {
		this.capacity_b = capacity_b;
	}
	/**
	 * @return the capacity_e
	 */
	public int getCapacity_e() {
		return capacity_e;
	}
	/**
	 * @param capacity_e the capacity_e to set
	 */
	public void setCapacity_e(int capacity_e) {
		this.capacity_e = capacity_e;
	}
	/**
	 * @return the cost_per_km
	 */
	public int getCost_per_km() {
		return cost_per_km;
	}
	/**
	 * @param cost_per_km the cost_per_km to set
	 */
	public void setCost_per_km(int cost_per_km) {
		this.cost_per_km = cost_per_km;
	}
	/**
	 * @return the flightlist
	 */
	public String getFlightlist() {
		return flightlist;
	}
	/**
	 * @param flightlist the flightlist to set
	 */
	public void setFlightlist(String flightlist) {
		this.flightlist = flightlist;
	}
	
}
