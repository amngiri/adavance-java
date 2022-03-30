package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

public class TutorialBean {
	//add dao ref 
	private TutorialDaoImpl tutDao;
	//add props to represent clnt's conversational state (req params)
	private int topicId;
	private String tutName;
	private String author;
	private String pubDate;
	private String contents;
	//add err mesg propert
	private String message;
	public TutorialBean() {
		System.out.println("in tut bean ctor");
		//create tut dao instance : as it's dependency
		tutDao=new TutorialDaoImpl();
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public void setTutName(String tutName) {
		this.tutName = tutName;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	public TutorialDaoImpl getTutDao() {
		return tutDao;
	}
	public String getMessage() {
		return message;
	}
	//add B.L method to validate i/ps n then insert new tut 
	public String validateAndInsertTutorial() 
	{
		//validation rules
		//conversion : string(date) : yr-mon-day ---> LocalDate 
		LocalDate date=LocalDate.parse(pubDate);
	
		int monthsElapsed=(int)Period.between(date,LocalDate.now()).toTotalMonths();
		System.out.println(monthsElapsed);
		if(contents.length() < 255 && monthsElapsed < 6)
		{
			//validation successful --proceed to insertion of a rec : call dao's method
			//tutorialName, String author, Date publishDate, String contents, int topicId
			message=tutDao.addNewTutorial(new Tutorial(tutName, author, date, contents),topicId);
			return "logout";//in  case of success ---> navigate the clnt to logout.jsp
		}	
		//validation failed
		message="Invalid form inputs : either contents or publish date";
		return "show_tutorial_form";
		
		
	}
	
	

}
