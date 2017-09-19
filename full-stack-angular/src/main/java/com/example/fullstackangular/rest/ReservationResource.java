package com.example.fullstackangular.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstackangular.model.response.ReservationResponse;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@RequestMapping(path="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> getAvailableRooms(
			@RequestParam("checkin")@DateTimeFormat(iso=ISO.DATE) LocalDate checkIn,
			@RequestParam("checkout")@DateTimeFormat(iso=ISO.DATE) LocalDate checkOut){
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}
}
