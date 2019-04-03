package com.jessicacastro.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jessicacastro.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
	
	
	/*
	 * Verifico as modificações feitas em determinado ticket, trazendo sempre pela última modificação feita. 
	 * 
	 * Feito por: Jessica Castro
	 * Data: 03/04/2019
	 */
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String tickedId);
	

}
