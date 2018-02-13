package com.contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contact.DAO.ContactRepersitory;
import com.contact.model.Contact;

@SpringBootApplication
public class AbouContactApplication implements CommandLineRunner {
	@Autowired
	private ContactRepersitory contactRepersitory;
	
	public static void main(String[] args) {
		SpringApplication.run(AbouContactApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		
		contactRepersitory.save(new Contact("Niare", "Marietou", df.parse("25/02/2001"), 
				"marietou.Niare1@gmail.com", 0622340156, "marietou.jpeg"));
		
		contactRepersitory.save(new Contact("Toure","Aichou",df.parse("08/03/1991"),
				"aichou0803.toure@gmail.com", 0256234601, "aichou.jpeg"));
		
		contactRepersitory.save(new Contact("Sissoko","Oumarou",df.parse("23/12/1991"),
				"sissoko.oumarou@gmail.com", 0627560134, "lucho.jpeg"));
		
		contactRepersitory.save(new Contact("Mehdi","Mehdi",df.parse("10/03/1991"),
				"mehdidu-75@hotmail.fr", 0675213604, "dims.jpeg"));
		
		contactRepersitory.save(new Contact("Toure","Aboubacar",df.parse("25/04/1991"),
				"aboubacar.toure91@gmail.com", 0622560134, "bouba.jpeg"));
		
		contactRepersitory.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
