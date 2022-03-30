package dao;

import java.sql.SQLException;

import pojos.Tutorial2;

public interface ITutorialDao2 {
	Tutorial2 getTutorialByName(String name) throws SQLException;
}
