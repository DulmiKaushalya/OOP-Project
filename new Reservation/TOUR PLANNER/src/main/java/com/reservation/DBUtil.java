package com.reservation;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
        
	
	private static Connection conn = null;
	private static Statement stmt = null;
	private static boolean updated;
	private static boolean deleted;
	private static boolean Inserted;

	public static boolean validateLogin(String username, String password) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM login_details WHERE tusername = '" + username + "' AND tpassword = '" + password
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);

			return rs.next(); // If a row is found, the login is valid.
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<ReservationDetails> read() {
		ArrayList<ReservationDetails> reservation = new ArrayList<>();

		try { 
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "select * from new_table ORDER BY reservationid DESC LIMIT 1";// *******************************table
																				// name and rentid
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String loc = rs.getString(3);
				String checkindate = rs.getString(4);
				String checkoutdate = rs.getString(5);
				String email = rs.getString(6);
				String phone = rs.getString(7);
				String other = rs.getString(8);

				ReservationDetails r = new ReservationDetails(id, name, loc, checkindate,checkoutdate, email, phone, other);
	
				reservation.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}

	public static boolean insert(String DBVname, String DBVLocation, String DBVcheckindate, String DBVcheckoutdate,String DBVemail,
			String DBVphone, String DBVother) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "insert into new_table values(0, '" + DBVname + "', '" + DBVLocation + "','"+ DBVcheckindate + "','"+DBVcheckoutdate+"', '" + DBVemail + "','" + DBVphone + "','" + DBVother + "')";// **************table
																										// name
			int sqlQueryCheck = stmt.executeUpdate(sql); // this returns 1 ,if the insert is done.

			if (sqlQueryCheck > 0) {
				Inserted = true;
			} else {
				Inserted = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Inserted;
	}

	public static boolean update(String DBUid, String DBUname, String DBULocation, String DBUcheckindate,String DBUcheckoutdate,
			String DBUemail, String DBUphone, String DBUother) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "update new_table set name='" + DBUname + "', location='" + DBULocation + "', checkindate='"
					+ DBUcheckindate + "',checkoutdate='"+DBUcheckoutdate+"' ,email='" + DBUemail + "', phone='" + DBUphone + "', other='" + DBUother + "'"
					+ "where reservationid='" + DBUid + "'";
			int rs = stmt.executeUpdate(sql);
			if (rs > 0) {
				updated = true;
			} else {
				updated = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	public static boolean delete(String DBDUid) {

		int deleteID = Integer.parseInt(DBDUid); // wrapper class

		try {

			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();
			String sql = "delete from new_table where reservationid='" + deleteID + "'";
			int r = stmt.executeUpdate(sql);

			if (r > 0) {
				deleted = true;
			} else {
				deleted = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
	
}
