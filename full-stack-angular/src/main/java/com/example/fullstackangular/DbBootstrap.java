package com.example.fullstackangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.fullstackangular.model.entity.RoomEntity;
import com.example.fullstackangular.model.repository.RoomRepository;

@Component
public class DbBootstrap implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepo;
	@Override
	public void run(String... args) throws Exception {
		roomRepo.save(new RoomEntity(420, new Double(78.97)));
		roomRepo.save(new RoomEntity(427, new Double(100)));
		roomRepo.save(new RoomEntity(820, new Double(69.78)));
		roomRepo.save(new RoomEntity(220, new Double(110)));
		
		roomRepo.findAll().forEach(room -> System.out.println(room.getId()+"-"+room.getRoomNumber()));
	}
	
}
