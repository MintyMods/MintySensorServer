package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.View;

public interface ViewDao {

	void addView(View view);

	Collection<View> getAllViews();

	View getViewById(Long id);

	void removeViewById(Long id);

	void updateView(View view);
}