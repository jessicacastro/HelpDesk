package com.jessicacastro.helpdesk.api.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jessicacastro.helpdesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String>{
	
	/*
	 * Filtrando tickets pelo Id do usuário. 
	 * 
	 * Feito por: Jessica Castro 
	 * Data: 03/04/2019
	 */
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);
	
	
	/*
	 * Fazendo filtro por vários parâmetros de pesquisa: Título, Status, Prioridade
	 * Com ordem decrescente. Ou seja, mostrando sempre o último. 
	 * 
	 * O IgnoreCase serve para ignorar letras maiúsculas e minúsculas.
	 * O Containing é equivalente ao LIKE.
	 * 
	 * Feito por: Jessica Castro
	 * Data: 03/04/2019
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	/*
	 * Lista somente os tickets de um determinado cliente com os filtros selecionados.
	 * 
	 * Feito por: Jessica Castro
	 * Data: 03/04/2019
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	
	/*
	 * Quando o técnico loga na tela de pesquisa, ele tem uma opção para pesquisar somente os tickets atribuídos a ele. 
	 * 
	 * Feito por: Jessica Castro
	 * Data: 03/04/2019
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	/*
	 * Pesquisa por número do Ticket, facilitando o encontro 
	 * do ticket correto
	 * 
	 * Criado por: Jessica Castro
	 * Data: 03/04/2019
	 */
	Page<Ticket> findByNumber(Integer number, Pageable pages);
	
}
