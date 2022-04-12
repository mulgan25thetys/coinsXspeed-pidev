package horizure.micro.finance.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.MethodRB;
import horizure.micro.finance.entities.Payement;
import horizure.micro.finance.repositories.FinancialServiceRepository;
import horizure.micro.finance.repositories.PayementRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class PayementServiceImpl implements IPayementService {
	
	double m ;
	Payement payement = new Payement();
	
	@Autowired
	PayementRepository PRepository;
	
	@Autowired
	FinancialServiceRepository FSRepository ;
	
	@Autowired
	UserRepository URepository ;
	
	@Transactional
	public double getMensuality(FinancialService FS) {
		double E = FS.getAmount();
		float I = FS.getInterest_pr();
		long n = FS.getDuration();
		float i = (I/12)/100 ;
		m = (E*i) /(1 - Math.pow((1+i),-n)); 
		payement.setMensuality(m);
		return m ;
	}
	
	@Transactional
	public List<Payement> getPayement_mensuality(Long id_ServiceFinancial){
		FinancialService FS = FSRepository.findById(id_ServiceFinancial).orElse(null);
		ArrayList<Payement> paymentList = new ArrayList<>();
		Payement payement = new Payement();
		//Date creation_date = new Date() ;
		Date creation_date = FS.getDate_of_creation() ;

		//LocalDate DateLimit = creation_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() ;		
		LocalDate DateLimit = LocalDate.now();

		double CRD = 0;
		double A = 0;
		double A_int = 0;
		double E = FS.getAmount();
		float I = FS.getInterest_pr();
		long n = FS.getDuration();
		float i = (I/12)/100 ;
		double interest = E * i ;
		double m=getMensuality(FS);
		A_int = m - interest;
		
		for(int k=0; k<n; k++) {
		payement = new Payement(); 
			 
			 if(k == 0) {
				 DateLimit = DateLimit.plusMonths(1) ;
				 CRD = E ; 
				 A =A_int;
			 }else {				 
				 //CRD = E - ((A_int/i) * (Math.pow((1+i),k))-1) ;
				 CRD=paymentList.get(k-1).getRemaining_amount()-paymentList.get(k-1).getAmortization();
				 interest = CRD * i;
				 A = m - interest;
				 DateLimit = DateLimit.plusMonths(1) ;
				 
			 }
			 payement.setMensuality(m);
			 payement.setRemaining_amount(CRD);
			 payement.setAmortization(A);
			 payement.setInterest(interest);
			 //payement.setFinancialService(FS) ;
			 payement.setDateLimit(DateLimit);
			 payement.setcreation_date(creation_date) ;
			 payement.setSevice_id(id_ServiceFinancial);
			 paymentList.add(payement);
		 }
		 
		return paymentList;
	}
	

	@Transactional
	public List<Payement> getPayement_Block(Long id_ServiceFinancial) {
		
		FinancialService FS = FSRepository.findById(id_ServiceFinancial).orElse(null);
		//User u = URepository.findById(idUser).orElse(null);
		ArrayList<Payement> paymentList = new ArrayList<>();
		Payement payement = new Payement();
		//long client_id = u.getUserId();
		Date creation_date = FS.getDate_of_creation() ;
		LocalDate DateLimit = LocalDate.now();
		
		double CRD = 0;
		double A = 0;
		double E = FS.getAmount();
		float I = FS.getInterest_pr();
		long n = FS.getDuration();
		float i = (I/12)/100 ;
		double interest = E * i ;
		
		 for(int k=0; k<n; k++) {
		payement = new Payement(); 
			 
			 if(k == n-1) {
				 CRD = E ;
				 A = CRD ;
				 m = A + interest ;
				 DateLimit = DateLimit.plusMonths(1);
			 }else {				 
				CRD = E ;
				interest = CRD * i ;
				A = 0 ;
				m = A + interest ;
				DateLimit = DateLimit.plusMonths(1);
				 
			 }
			 payement.setMensuality(m);
			 payement.setRemaining_amount(CRD);
			 payement.setAmortization(A);
			 payement.setInterest(interest);
			 //payement.setFinancialService(FS) ;
			 payement.setDateLimit(DateLimit);
			 payement.setcreation_date(creation_date) ;
			 payement.setSevice_id(id_ServiceFinancial);
			 //payement.setClient_id();
			 paymentList.add(payement);
		 }
		 
		return paymentList;
	}

	@Transactional
	public List<Payement> addPayement(long id_ServiceFinancial) {
		FinancialService FS = FSRepository.findById(id_ServiceFinancial).orElse(null);
		List<Payement> paymentList = new ArrayList<>();
		
		if(FS.getReimbment_method() == MethodRB.Mensuality )
		{
			paymentList = getPayement_mensuality(id_ServiceFinancial);
		}
		else if(FS.getReimbment_method() == MethodRB.Block)
		{
			paymentList = getPayement_Block(id_ServiceFinancial);
		}
		
		PRepository.saveAll((List<Payement>) paymentList);
		
		return paymentList;
	}

	@Override
	public List<Payement> retrieveAllPayement() {
		return (List<Payement>) PRepository.findAll();
	}

	@Override
	public Payement retrievePayement(Long id) {
		return PRepository.findById(id).orElse(null);
	}

	@Override
	public Payement updatePayement(Payement P) {
		return PRepository.save(P);
	}


	
	/*  
	 	 public List<double> getAmortization()
	 {
	 	this.E = getAmount();
	 	this.I = getInterst_pr();
	 	this.n = getDuration();
	 	float i = I/12 ;
	 	double A1 = (E * i) / (math.pow(1+i,n)-1) ;  
	 	ArrayList lA = new ArrayList();
	 	lA[1].add(A1);
	 	for(k=2 ; k =< n ; k++)
	 	{
	 		double A = A1 * (Math.pow(1+i,k-1))
	 		lA.add(A);
	 	}
	 	
	 	return lA();
	 }
	 
	 public List<double> getRemainingAmount()
	 {
	 	this.E = getAmount();
	 	this.I = getInterst_pr();
	 	this.n = getDuration();
	 	float interest = I/12 ;
	 	double CRD = E ;
	 	double A =lA.get(1) ;
	 	ArrayList lCRD = new ArrayList();
	 	lCRD[1].add(CRD);
	 	for(k=2 ; k =< n ; k++)
	 	{
	 		double CRD = E - ((A1/i) * (math.pow((1+i),k-1))-1); 
	 		lCRD.add(CRD);
	 	}
	 	
	 	return LCRD();
	 }
	 
	 public List<double> getInterest()
	 {
	 	this.E = getAmount();
	 	this.I = getInterst_pr();
	 	this.n = getDuration();
	 	float i = I/12 ;
	 	ArrayList lI = new ArrayList();
	 	for(k=1 ; k =< n ; k++) // car le premier CRD = E 
	 	{
	 		double In = (lCRD.get(i))*i ;
	 		lI.add(In);
	 	}
	 	
	 	return lI() ;
	 }
	 
	 
	 	 public List<Payement> getPayement()
	 {
	 	this.E = getAmount();
	 	this.I = getInterst_pr();
	 	this.n = getDuration();
	 	float i = I/12 ;
	 	double m = getMensuality() ;
	 	List <List<Payement>> superListe = new ArrayList()
	 	for(k=1 ; k =< n ; k++)
	 	{
	 		ArrayList lP = new ArrayList();
	 		lP.add(lCRD.get(k);
	 		lP.add(lA.get(k));
	 		lP.add(lI.get(k));
	 		lP.add(m);
	 		superListe.add(lP);
	 	}
	 	
	 	return superListe() ;
	 }
	 
	 
	 
	 */

	}
