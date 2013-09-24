package com.answer1991.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.answer1991.entity.listener.GalleryListener;


/**
 * The persistent class for the gallery database table.
 * 
 */
@Entity
@EntityListeners(GalleryListener.class)
@NamedQuery(name="Gallery.findAll", query="SELECT g FROM Gallery g")
public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="cover_img_url")
	private String coverImgUrl;

	private String description;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User user;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="gallery", cascade = CascadeType.ALL)
	private List<Photo> photoes;

	public Gallery() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoverImgUrl() {
		return this.coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Photo> getPhotoes() {
		return this.photoes;
	}

	public void setPhotoes(List<Photo> photoes) {
		this.photoes = photoes;
	}

	public Photo addPhotoe(Photo photoe) {
		getPhotoes().add(photoe);
		photoe.setGallery(this);

		return photoe;
	}

	public Photo removePhotoe(Photo photoe) {
		getPhotoes().remove(photoe);
		photoe.setGallery(null);

		return photoe;
	}

}