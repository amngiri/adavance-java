package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Tutorial;
import utils.HibernateUtils;

class TestTutorialDaoImpl {
	private static TutorialDaoImpl tutorialDao;

	@BeforeAll
	public static void setUp() {
		System.out.println("in set up");
		tutorialDao = new TutorialDaoImpl();
	}

//test case to test dao's method : getTutorialsByTopicId
	@Test
	void testGetTutorialsByTopicId() {

		List<String> tutorialNames = tutorialDao.getTutorialsByTopicId(4);
		System.out.println(tutorialNames);
		assertEquals(3, tutorialNames.size());
	}

	// test case to test dao's method : getTutorialDetails
	@Test
	public void testGetTutorialDetails() {
		Tutorial tutorial = tutorialDao.getTutorialDetails("Spring MVC");
		// for additional confirmation print tut's contents
		System.out.println(tutorial);
		assertEquals(12, tutorial.getVisits());
	}

	@Test
	public void testUpdateVisits() {
		String msg = tutorialDao.updateVisits("Spring Core");
		System.out.println(msg);
		assertEquals(msg, "updated visits");
	}

//	@Test
//	public void testaddNewTutorial()
//	{
//	String msg = tutorialDao.addNewTutorial()
//	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("in clean up");
		HibernateUtils.getFactory().close();
	}

}
