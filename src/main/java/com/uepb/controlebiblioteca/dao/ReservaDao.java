package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Reserva;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface ReservaDao {

	public void addReserva(Reserva reserva);

	public List<Reserva> getAllReservas();

	public void deleteReserva(Integer reservaId);

	public Reserva updateReserva(Reserva reserva);

	public Reserva getReserva(int reservaid);
}
