package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Notification;
import tn.esprit.spring.models.Tran;
import tn.esprit.spring.services.ITranService;

@RestController
public class TranController {
	@Autowired
	ITranService tranService;
	
	@PostMapping("/add-Tran/{client-id}")
	@ResponseBody
	public Tran addTran(@RequestBody Tran c,@PathVariable("client-id") String id_client) {
		Tran tran= tranService.addTransaction(c,Long.valueOf(id_client));
		return tran;
	}
	
	@PutMapping("/modify-Tran/{client-id}")
	@ResponseBody
	public Tran modifyTran(@RequestBody Tran c,@PathVariable("client-id") String id_client) {
		return tranService.ModifierTransaction(c,Long.valueOf(id_client));
	}

	
	
}
