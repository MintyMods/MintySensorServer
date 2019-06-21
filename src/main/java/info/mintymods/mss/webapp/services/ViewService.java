package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ViewDao;
import info.mintymods.repository.entities.View;

@Service
public class ViewService {

	@Autowired
	@Qualifier("fakeData")
	private ViewDao viewDao;

	public Collection<View> getAllViews() {
		return viewDao.getAllViews();
	}

	public View getViewById(Long id) {
		return viewDao.getViewById(id);
	}

	public void insertView(View view) {
		viewDao.addView(view);
	}

	public void removeViewById(Long id) {
		viewDao.removeViewById(id);
	}

	public void updateView(View view) {
		viewDao.updateView(view);
	}
}
