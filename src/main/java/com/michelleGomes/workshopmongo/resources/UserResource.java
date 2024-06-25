package com.michelleGomes.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.michelleGomes.workshopmongo.domain.Post;
import com.michelleGomes.workshopmongo.domain.User;
import com.michelleGomes.workshopmongo.dto.UserDTO;
import com.michelleGomes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired 
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
		
		User user = service.fromDTO(userDTO);
		user = service.insert(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
		
		User user = service.fromDTO(userDTO);
		user.setId(id);
		user = service.update(user);
		
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(user.getPosts());
	}
	
}
