package com.restapi.saein.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.saein.dto.ContentsDto;
import com.restapi.saein.dto.UserDto;
import com.restapi.saein.repository.UserRepository;
import com.restapi.saein.service.ContentsService;

@RestController
@RequestMapping("/rest")
public class RestApiController {
	
	@Value("${api.contents.url}")
	private String url;
	
	@Value("${api.contents.clientid}")
	private String id;
	
	@Value("${api.contents.clientkey}")
	private String key;
	
	@Autowired
	private ContentsService contentsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/search/contents",  produces = "application/json; charset=utf8")
	public ResponseEntity<ContentsDto> searchMain(@ModelAttribute ContentsDto dto) {
		return new ResponseEntity<ContentsDto>(contentsService.searchContents(dto, url, id, key), HttpStatus.OK);
	}
	
	@PostMapping(value = "/create/user")
	public ResponseEntity<UserDto> createUser(@ModelAttribute UserDto dto){
		return new ResponseEntity<UserDto>(userRepository.save(dto), HttpStatus.OK);
	}
	
}
