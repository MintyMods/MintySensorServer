package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Reading;

@Repository
public interface ReadingDoa extends PagingAndSortingRepository<Reading, Long> {
}