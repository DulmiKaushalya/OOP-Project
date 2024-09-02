package com.reservation;

public class ReservationDetails {
	
	private int id;
	private String name;
	private String Location;
	private String Checkindate;
	private String Checkoutdate;
	private String email;
	private String phone;
	private String other;
	
	public ReservationDetails(int id, String name, String location, String checkindate, String checkoutdate, String email,
			String phone, String other) {
		
		this.id = id;
		this.name = name;
		Location = location;
		Checkindate = checkindate;
		Checkoutdate = checkoutdate;
		this.email = email;
		this.phone = phone;
		this.other = other;
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public String getLocation() {
		return Location;
	}


	public String getCheckindate() {
		return Checkindate;
	}


	public String getCheckoutdate() {
		return Checkoutdate;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}

	

	public String getOther() {
		return other;
	}
	

}
