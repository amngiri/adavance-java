package pojos;

public class Topic {
private int id;
@Override
public String toString() {
	return "Topic [id=" + id + ", name=" + name + "]";
}
private String name;

public Topic(int id, String name) {
	this.id=id;
	this.name=name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
