package com.example.demo.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;


@Mapper
public interface UMapper {
	
	//全件表示
	public List<User> find();
	
	//insert
	public void insertOne(User u);

}
