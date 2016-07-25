package ams;


public class Route {
	private int id;
	private String start;
	private String dest;
	private int distance;
	private String flightlist;
        
        public Route(String flt, String st, String des, int d){
            flightlist = flt;
            dest = des;
            distance = d;
            start = st;
        }
        public Route(){
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
	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
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
