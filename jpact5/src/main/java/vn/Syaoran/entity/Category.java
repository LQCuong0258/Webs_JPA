package vn.Syaoran.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll",query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="Categoryid")
	private int categoryid;
	
	@Column(name="Categoryname", columnDefinition ="NVARCHAR(200) NOT NULL")
	private String categoryname;
	
	@Column(name="Image", columnDefinition ="NVARCHAR(500) NULL")
	private String image;
	
	@Column(name="Status")
	private int status ;
	
	@OneToMany(mappedBy = "category")
	private List<Video> videos;

	public Category() {}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setCategory(this);
		return video;
	}
	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setCategory(null);
		return video;
	}
	
	
}
