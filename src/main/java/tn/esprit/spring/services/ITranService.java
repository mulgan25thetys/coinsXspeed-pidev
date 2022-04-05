package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.Tran;

public interface ITranService {
	Tran addTransaction(Tran t,Long id_client);
	Tran ModifierTransaction(Tran t, Long id_client);
}
