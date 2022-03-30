package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Player;

@Repository
@Transactional
public class PlayerDaoImpl implements IPlayerDao {
	@Autowired
	private SessionFactory mgr;

	@Override
	public List<Player> getAllPlayer() {

		return mgr.getCurrentSession().createQuery("select p from Player p", Player.class).getResultList();
	}

	@Override
	public Player bestBatsman(int stats, String role) {
		String jpql = "select p from Player p where p.stats=(select max(b.stats) from Player b where b.role=:role)";
		// SELECT p FROM Product p WHERE p.price <
		// (SELECT MAX(p.price) FROM p)"
		return mgr.getCurrentSession().createQuery("jpql", Player.class).setParameter("role", role).getSingleResult();
	}

	@Override
	public Player bestBowler(int stats, String role) {
		String jpql = "select p from Player p where p.stats=(select max(b.stats) from Player b where b.role=:role)";
		return mgr.getCurrentSession().createQuery("jpql", Player.class).setParameter("role", role).getSingleResult();
	}

	@Override
	public String removePlayer(int id) {
		String jpql = "delete from Player p where p.id=:id";
		int status = mgr.getCurrentSession().createQuery("jpql", Player.class).setParameter("id", id).executeUpdate();
		if (status == 1)
			return "Player deleted";
		return "Player Deletion Failed";
	}

	@Override
	public String addPlayer(Player player) {
		mgr.getCurrentSession().save(player);
		return "Player Added";

	}

}
