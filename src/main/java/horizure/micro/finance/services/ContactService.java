package horizure.micro.finance.services;

import org.springframework.data.domain.Page;

import horizure.micro.finance.entities.Contact;

public interface ContactService {
	public Contact savaContact(Contact c);
	public void updateContact(Long id,Contact c);
	public void delet(Long id);
	public Contact contact(Long id);
	public Page<Contact> ContactparMc(String mc,int p,int size);
	public Page<Contact> contacts( int page,int size);

}
