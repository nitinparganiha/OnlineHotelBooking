package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HotelRoom {
	@Id
	private int RoomNo;
	private double price;
	private String BookingStatus;
	@Temporal(TemporalType.DATE)
	private Date checkin;
	@Temporal(TemporalType.DATE)
	private Date checkout;
	private int countroom;
	private String location;
	private int flour;
	private String HotelName;
	private String custemail;
	private String  img1;
	private String img2;
	private String img3;


	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookingStatus() {
		return BookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public Date getFrom() {
		return checkin;
	}

	public void setFrom(Date from) {
		this.checkin = from;
	}

	public Date getTo() {
		return checkout;
	}

	public void setTo(Date to) {
		this.checkout = to;
	}

	public int getCountroom() {
		return countroom;
	}

	public void setCountroom(int countroom) {
		this.countroom = countroom;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFlour() {
		return flour;
	}

	public void setFlour(int flour) {
		this.flour = flour;
	}

	public String getHotelName() {
		return HotelName;
	}

	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}

}
