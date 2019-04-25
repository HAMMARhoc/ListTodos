package com.hocine.listeTodos.controller;

import java.util.Date;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hocine.listeTodos.DAO.IlisteTodosDao;
import com.hocine.listeTodos.Entity.ListeTodos;

@Controller
public class TestController {
	@Autowired
	IlisteTodosDao dao;
	@Autowired
	EntityManager entityManager;

	@ResponseBody
	@RequestMapping("/")
	public String home() {
		String html = "";
		html += "<ul>";
		html += " <li><a href='/showAllTodos'>voir listTodos</a></li>";
		html += " <li><a href='/deleteAllTodos'>delete listTodos</a></li>";
		html += " <li><a href='/testInsert\"'>insert listTodos</a></li>";
		html += " <li><a href='/deleteTodo'>delete Todo</a></li>";
		html += " <li><a href='/updatListeTodos'>update liste</a></li>";
		html += "</ul>";
		return html;
	}

	@ResponseBody
	@RequestMapping("/showAllTodos")
	public String showAllTodos(Model model) {
		String html = "";
		Iterable<ListeTodos> list = dao.findAll();
		for (ListeTodos listd : list)
			html += listd + "<br>";
		return html;
	}


	@ResponseBody
	@RequestMapping("/updatListeTodos")
	public Long updatListeTodos(Long Id, String intitule, Date dateFin, String indicFin) {
		ListeTodos liste = entityManager.find(ListeTodos.class, Id);
		if (liste == null) {
			return (long) 0;
		}
		liste.setIntitule(intitule);;
		liste.setDateFin(dateFin);
		liste.setIndicFin(indicFin);
		entityManager.flush();
		return (long) 1;

	}

	@ResponseBody
	@RequestMapping("/testInsert")
	public void testInsert() {
		ListeTodos todo = new ListeTodos();
		dao.creatListeTodos(todo);
	}

	@ResponseBody
	@RequestMapping("/deleteTodo")
	public void deleteTodo() {
		this.dao.deletTodos();
	}

	@ResponseBody
	@RequestMapping("/deleteAllTodos")
	public String deleteAllList() {

		this.dao.deleteAll();
		return "Deleted!";
	}

	

}
