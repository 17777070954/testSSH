package testSSH.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import testSSH.DAO.HibernateSessionFactory;
import testSSH.DAO.Position;
import testSSH.DAO.PositionDao;

public class JsonAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private String result;
	private Map<String, Object> map;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 处理请求
	 * 
	 * @return SUCCESS
	 */
	public String excuteAjax() {
		try {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String position = request.getParameter("position");

			map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("age", new Integer(age).toString());
			map.put("position", position);
			save();

			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new Exception("转换出错了");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				return "fail";
			}
		}
		return SUCCESS;
	}

	private void save() {
		Position position = new Position();
		position.setName((String) map.get("name"));
		position.setAge(Integer.parseInt((String) map.get("age")));
		position.setPosition((String) map.get("position"));

		PositionDao dao = new PositionDao();
		dao.save(position);
	}
}
