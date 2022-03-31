package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import horizure.micro.finance.entities.Mail;

public interface IMailrepository extends JpaRepository<Mail, Long> {

}
