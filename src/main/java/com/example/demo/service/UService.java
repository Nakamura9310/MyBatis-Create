package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UMapper;


@Service
public class UService {
	
	@Autowired
	UMapper mapper;
	
	//select全件
	public List<User> getList() {
		return mapper.find();
	}
	
	//insert
	@Transactional
	public void insertOne(User u) {
		mapper.insertOne(u);
	}
	
}
