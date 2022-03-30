package pojos;

import javax.persistence.*;

@MappedSuperclass // class level annotation , to tell JPA(hibernate) that it's a common super
					// class for all the entities n DO NOT generate any table for it.
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
