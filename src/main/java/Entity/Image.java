package Entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Image {
	@Id
int id;
	@Lob
Blob image;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}

}
