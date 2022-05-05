package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
