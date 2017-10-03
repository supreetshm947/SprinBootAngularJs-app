package com.example.fullstackangular.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.fullstackangular.model.Links;
import com.example.fullstackangular.model.Self;
import com.example.fullstackangular.model.entity.RoomEntity;
import com.example.fullstackangular.model.response.ReservationResponse;
import com.example.fullstackangular.rest.ResourceConstants;

public class RoomEntityToReservationResponseCoverter implements Converter<RoomEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(RoomEntity source) {
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(source.getPrice());
		
		Links link = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1+"/"+source.getId());
		link.setSelf(self);
		
		reservationResponse.setLinks(link);
		
		return reservationResponse;
	}

}
