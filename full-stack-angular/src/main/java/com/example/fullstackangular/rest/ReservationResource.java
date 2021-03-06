package com.example.fullstackangular.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstackangular.converter.RoomEntityToReservationResponseCoverter;
import com.example.fullstackangular.model.entity.RoomEntity;
import com.example.fullstackangular.model.repository.PageableRoomRepository;
import com.example.fullstackangular.model.repository.RoomRepository;
import com.example.fullstackangular.model.request.ReservationRequest;
import com.example.fullstackangular.model.response.ReservationResponse;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {
	
	@Autowired
	PageableRoomRepository pageableRoomRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@RequestMapping(path="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservationResponse> getAvailableRooms(
			@RequestParam("checkin")@DateTimeFormat(iso=ISO.DATE) LocalDate checkIn,
			@RequestParam("checkout")@DateTimeFormat(iso=ISO.DATE) LocalDate checkOut,Pageable pageable){
		Page<RoomEntity> page = pageableRoomRepository.findAll(pageable);
		
		return page.map((Converter)new RoomEntityToReservationResponseCoverter());
	}
	
	@RequestMapping(path="/{roomId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId){
		return new ResponseEntity<>(roomRepository.findById(roomId), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path="", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> updateReservation(
			@RequestBody ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/{reservationId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable Long reservationId){
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
