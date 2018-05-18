package com.uepb.controlebiblioteca.service;

import java.util.List;

import com.uepb.controlebiblioteca.model.Reserva;

public interface ReservaService {
	
	public void addReserva(Reserva emprestimo);

	public List<Reserva> getAllReservas();

	public void deleteReserva(Integer emprestimoId);

	public Reserva getReserva(int emprestimoId);

	public Reserva updateReserva(Reserva emprestimo);
}
