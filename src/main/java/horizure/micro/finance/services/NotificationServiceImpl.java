package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.EsentOn;
import horizure.micro.finance.entities.Notification;
import horizure.micro.finance.entities.TypeNotification;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.NotificationRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class NotificationServiceImpl implements INotificationService{

	@Autowired
	EmailService emailservice;
	
	@Autowired
	UserRepository repos;
	
	@Autowired
	NotificationRepository notificationRepository;
	@Transactional
	public Notification addNotification(Notification notif,Long id) {
		// TODO Auto-generated method stub
		User user = repos.findById(id).orElse(null);
		
		if(notif.getType()  == TypeNotification.CONFIRMATION) {
			emailservice.sendSimpleMessage(user.getUserName(), user.getEmail(), notif.getObject(), notif.getMessage(), "");
			notif.setCreated_at(new Date());
			
			notif.setSent_on(EsentOn.EMAIL);
			notif.setSended(true);
			user.getNotifications().add(notif);
			//notif.getUsers().add(user);
			repos.save(user);
			notificationRepository.save(notif);
		}
		return notif;
	}
	@Transactional
	public Notification addContact(Notification n) {
		// TODO Auto-generated method stub
		List<User> admins = repos.findAll().stream()
    	        .filter(u ->  u.getRole() != "CLIENT")
    	        .collect(Collectors.toList());
		
		n.setCreated_at(new Date());
		n.setSended(true);
		n.setSent_on(EsentOn.INTERNAL);
		for (User user : admins) {
			user.getNotifications().add(n);
		}
		repos.saveAll(admins);
		return notificationRepository.save(n);
	}

	@Override
	public List<Notification> getNotifications(){
		return (List<Notification>)notificationRepository.findAll();
	}
	@Override
	public void deleteNotification(Long id) {
		// TODO Auto-generated method stub
		Notification notif = notificationRepository.findById(id).orElse(null);
		if(notif !=null) {
			notificationRepository.delete(notif);
		}
	}
}
