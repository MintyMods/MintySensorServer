package info.mintymods.mss.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ViewDao;
import info.mintymods.repository.entities.View;

@Service
public class ViewService {

	@Autowired
	private ViewDao viewDao;

	public List<View> getAllViews() {
		final List<View> views = new ArrayList<>();
		viewDao.findAll().forEach(views::add);
		return views;
	}

	public Optional<View> getView(Long id) {
		return viewDao.findById(id);
	}

	public void addView(View view) {
		viewDao.save(view);
	}

	public void deleteView(Long id) {
		viewDao.deleteById(id);
	}

	public void updateView(View view) {
		viewDao.save(view);
	}
}
