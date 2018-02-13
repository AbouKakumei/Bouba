package com.contact.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contact.model.Contact;

public interface ContactRepersitory extends JpaRepository<Contact,Long> {
	@Query("select c from Contact c where c.nom like :x")
	public Page<Contact> chercher(@Param("x")String mc, Pageable pageable);
}
