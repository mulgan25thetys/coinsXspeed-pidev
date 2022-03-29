package horizure.micro.finance.services;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;

import horizure.micro.finance.entities.Contact;
import horizure.micro.finance.repositories.ContactRepositry;

public class ContactServiceimpl implements ContactService {
	@Autowired
	ContactRepositry contactRepositry;

	@Override
	public Contact savaContact(Contact c) {
		// TODO Auto-generated method stub
		return contactRepositry.save(c);
	}

	@Override
	public void updateContact(Long id, Contact c) {
		c.setId(id);
		contactRepositry.save(c);
		
		
		
	}

	@Override
	public void delet(Long id) {
		contactRepositry.deleteById(id);
		
	}

	@Override
	public Contact contact(Long id) {
		 Optional<Contact> c=contactRepositry.findById(id);
	        return c.get();
		
	}

	@Override
	public Page<Contact> ContactparMc(String mc, int p, int size) {
		// TODO Auto-generated method stub
		return contactRepositry.listeContactParMC(mc, PageRequest.of(p, size));
	}

	@Override
	public Page<Contact> contacts(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}0
