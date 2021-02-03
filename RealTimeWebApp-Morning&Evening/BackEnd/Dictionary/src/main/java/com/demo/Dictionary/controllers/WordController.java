package com.demo.Dictionary.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dictionary.crud.services.IWordService;
import com.demo.Dictionary.entities.Word;


@RestController
@RequestMapping("word")
public class WordController implements IWordService{
	
	@Autowired
	IWordService iWordService;
	
	@GetMapping("/test")
	public String text() {
		return "Success";
	}
	
	@PostMapping("/save")
	public Word save(@RequestBody Word word) {
		return iWordService.save(word);
	}
		
	@GetMapping("/getAll")
	public List<Word> getAll() {
		return iWordService.getAll();

	}
	
	@GetMapping("/delete/{id}")
	public int deleteById(int id) {
		return iWordService.deleteById(id);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody Word word) {
		return iWordService.update(word);
	}
}
