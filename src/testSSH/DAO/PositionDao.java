package testSSH.DAO;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class PositionDao extends HibernateDaoSupport{

	public PositionDao() {
		// TODO Auto-generated constructor stub
	}

	public void save(Object obj) {
		this.getHibernateTemplate().save(obj);
	}
	
	public void delete(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}
	
	public List<?> list(Object obj) {
		return this.getHibernateTemplate().findByExample(obj);
	}
}
