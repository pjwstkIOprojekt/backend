package com.example.io_backend.controller;

import com.example.io_backend.model.enums.EmergencyType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController()
@RequestMapping(path = "/enum")
@RequiredArgsConstructor
public class EnumController {
	@GetMapping("/emergency_type")
	public List<String> getEmergencyTypeList(){
		return Stream.of(EmergencyType.values())
				.map(EmergencyType::name)
				.collect(Collectors.toList());
	}
}
