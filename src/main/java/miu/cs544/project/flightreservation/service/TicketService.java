package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.repository.TicketRepository;

@Service
@Data
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> allTickets(){
		return repository.findAll();
	}
	
	public Ticket saveTicket(Ticket ticket) {
		return repository.save(ticket);
	}
}
