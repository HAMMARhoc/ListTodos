package com.hocine.listeTodos.DAO;

import java.util.Date;
import java.util.List;


import org.springframework.data.repository.Repository;

import com.hocine.listeTodos.Entity.ListeTodos;

public interface IlisteTodosDao extends Repository<ListeTodos, Long>{
	public List<ListeTodos> findAll();
	public List<ListeTodos> creatListeTodos(ListeTodos todo);
	public Long updatListeTodos(Long Id, String intitule, Date dateFin, String indicFin );
	public List<ListeTodos> deletTodos();
	public List<ListeTodos> deleteAll();
	

}
