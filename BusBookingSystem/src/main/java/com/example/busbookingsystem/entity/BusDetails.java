package com.example.busbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
@DynamicUpdate
public class BusDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busNumber;

	private LocalDate journeyDate;

	private LocalTime journeyTime;

	private int totalSeats;

	private int availableSeats;

	@NotEmpty(message = "please enter source")
	private String source;

	@NotEmpty(message = "please enter destination")
	private String destination;

	// @NotBlank(message = "price cannot blank")
	private double ticketPrice;

	public BusDetails() {
		super();
	}

	public BusDetails(int busNumber, LocalDate journeyDate, LocalTime journeyTime, int totalSeats, int availableSeats,
			@NotEmpty(message = "please enter source") String source,
			@NotEmpty(message = "please enter destination") String destination, double ticketPrice) {
		super();
		this.busNumber = busNumber;
		this.journeyDate = journeyDate;
		this.journeyTime = journeyTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public LocalTime getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(LocalTime journeyTime) {
		this.journeyTime = journeyTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "BusDetails [busNumber=" + busNumber + ", journeyDate=" + journeyDate + ", journeyTime=" + journeyTime
				+ ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats + ", source=" + source
				+ ", destination=" + destination + ", ticketPrice=" + ticketPrice + "]";
	}

}