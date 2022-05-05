package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Notification;
import horizure.micro.finance.services.INotificationService;

@RestController
@RequestMapping("notification")
public class NotificationController {

	@Autowired
	INotificationService iNotificationService;
	
	@PostMapping("send-notification/{id}")
	@ResponseBody
	public Notification addNotification(@RequestBody Notification n,@PathVariable("id") Long id) {
		return iNotificationService.addNotification(n,id);
	}
	
	@PostMapping("add-notification")
	@ResponseBody
	public Notification addContact(@RequestBody Notification n) {
		return iNotificationService.addContact(n);
	}
	
	@GetMapping("list-all")
	@ResponseBody
	public List<Notification> getAll() {
		return iNotificationService.getNotifications();
	}
	
	@DeleteMapping("delete-notif/{id}")
	@ResponseBody
	public void deleteNotif(@PathVariable("id") Long id) {
		 iNotificationService.deleteNotification(id);
	}
}
