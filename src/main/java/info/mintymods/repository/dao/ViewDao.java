package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.View;

@Repository
public interface ViewDao extends PagingAndSortingRepository<View, Long> {
}