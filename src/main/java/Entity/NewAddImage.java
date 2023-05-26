package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

@Entity
public class NewAddImage {
	@Id
private int RoomNo;
private String  img1;
private String img2;
private String img3;
public int getId() {
	return RoomNo;
}
public void setId(int id) {
	this.RoomNo = id;
}
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




}
