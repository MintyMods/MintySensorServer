package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.View;

public interface ViewDao extends PagingAndSortingRepository<View, Long> {
}