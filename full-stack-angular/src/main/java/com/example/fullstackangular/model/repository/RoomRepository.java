package com.example.fullstackangular.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.fullstackangular.model.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long>{
	
	RoomEntity findById(Long id);

}
