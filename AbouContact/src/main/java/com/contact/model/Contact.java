package com.contact.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Contact implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	private Date date;
	private String email;
	private long tel;
	private String photo;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Contact(String nom, String prenom, Date date, String email, long tel, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.email = email;
		this.tel = tel;
		this.photo = photo;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	

}
