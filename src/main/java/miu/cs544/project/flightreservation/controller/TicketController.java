package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.service.TicketService;

@RestController
@Data
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/tickets")
	public List<Ticket> allTickets(){
		return ticketService.allTickets();
	}
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}
}
