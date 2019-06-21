package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.fake.ViewDao;
import info.mintymods.repository.entities.View;

@Service
public class ViewService {

	@Autowired
	@Qualifier("fakeData")
	private ViewDao viewDao;

	public Collection<View> getAllViews() {
		return viewDao.getAllViews();
	}

	public View getViewById(int id) {
		return viewDao.getViewById(id);
	}
	
	public void removeViewById(int id) {
		this.viewDao.removeViewById(id);
	}

	public void updateView(View view) {
		viewDao.updateView(view);
	}

	public void insertView(View view) {
		viewDao.addView(view);
	}
}
