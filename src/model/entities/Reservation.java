package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//CONSTRUCTORS MOTOD
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		setRoomNumber(roomNumber);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	//SETS AND GETS METOD
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	 //OTHERS METOD
	public long duration() {
		long diff = getCheckOut().getTime() - getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDate(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkOut.before(now) || checkIn.before(now)) {
			return "Reservation dates update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out must be after than check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
		
	}
	
	//TOSTRING
	public String toString() {
		return "Reservation: Room "
				+ getRoomNumber()
				+ ", check-in: "
				+ sdf.format(getCheckIn())
				+ ", check-out: "
				+ sdf.format(getCheckOut())
				+ ", " + duration() + " nights";
	}
	
	
}
