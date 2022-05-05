package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Notification;

public interface INotificationService {
	Notification addNotification(Notification notif,Long id);

	Notification addContact(Notification n);

	List<Notification> getNotifications();

	void deleteNotification(Long id);

}
