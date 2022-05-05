package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Payement;
import horizure.micro.finance.services.IPayementService;

@RestController
@RequestMapping("payement")
public class PayementController {
	@Autowired
	IPayementService iPayementService;
	
	@GetMapping("/get-payement-mensuality/{idfinancial}")
	@ResponseBody
	public List<Payement> getPayement_mensuality(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return null;
	}
	
	@GetMapping("/get-payement-block/{idfinancial}")
	@ResponseBody
	public List<Payement> getPayement_Block(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return null;
	}
	
	@PostMapping("/add-payement/{idfinancial}")
	@ResponseBody
	public List<Payement> addPayement(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return null;
	}
	
	
	@GetMapping("/list-payement")
	@ResponseBody
	public List<Payement> retrieveAllPayement(){
		return iPayementService.retrieveAllPayement();
	}
	
	@GetMapping("/get-payement-financial-service/{id_fs}")
	@ResponseBody
	public List<Payement> retrievePayementFS(@PathVariable("id_fs") Long id_fs){
		return iPayementService.retrievePayementFinancialService(id_fs);
	}
	
	@GetMapping("/get-payement-account/{id_acc}")
	@ResponseBody
	public List<Payement> retrievePayementAccount(@PathVariable("id_acc") Long id_account){
		return iPayementService.retrievePayementAccount(id_account);
	}
	
	@GetMapping("/get-payement-financial-service-account/{id_fs}/{id_acc}")
	@ResponseBody
	public List<Payement> retrievePayementFSAccount(@PathVariable("id_fs") Long id_fs,@PathVariable("id_acc") Long id_account){
		return iPayementService.retrievePayementFinancialServiceAccount(id_fs, id_account);
	}
	
	@GetMapping("/get-payement/{id_Payement}")
	@ResponseBody
	public Payement retrievePayement(@PathVariable("id_Payement") Long id_Payement){
		return iPayementService.retrievePayement(id_Payement);
	}
	
	@PutMapping("/modify-payement")
	@ResponseBody
	public Payement updateFinancialService(@PathVariable Payement P) {
		return iPayementService.updatePayement(P);
	}
	
	/*@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Payement> listPayement = iPayementService).listAll();
         
        PayementPDFExporter exporter = new PayementPDFExporter(listPayement);
        exporter.export(response);
         
    }*/

}
