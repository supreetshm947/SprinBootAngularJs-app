package com.example.fullstackangular.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.fullstackangular.model.entity.RoomEntity;

public interface PageableRoomRepository extends PagingAndSortingRepository<RoomEntity, Long>{
	Page<RoomEntity> findById(Long id, Pageable page); 
}
