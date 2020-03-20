package com.mindtree.entity;

public class MovieTicket {
	private int ticketId;
	private String movieName;
	private int ticketPrice;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public MovieTicket(int ticketId, String movieName, int ticketPrice) {
		super();
		this.ticketId = ticketId;
		this.movieName = movieName;
		this.ticketPrice = ticketPrice;
	}
	public MovieTicket() {
	
	}
	
	

}
