package info.mintymods.repository.dao.fake;

import java.util.Collection;

import info.mintymods.repository.entities.View;

public interface ViewDao {

	Collection<View> getAllViews();

	View getViewById(int id);

	void removeViewById(int id);

	void updateView(View view);

	void addView(View view);

}