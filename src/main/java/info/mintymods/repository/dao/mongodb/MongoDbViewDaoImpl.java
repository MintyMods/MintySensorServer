package info.mintymods.repository.dao.mongodb;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ViewDao;
import info.mintymods.repository.entities.View;

@Repository
@Qualifier("mongodbData")
public class MongoDbViewDaoImpl implements ViewDao {

	@Override
	public void addView(View view) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<View> getAllViews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getViewById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeViewById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateView(View view) {
		// TODO Auto-generated method stub
	}
}
