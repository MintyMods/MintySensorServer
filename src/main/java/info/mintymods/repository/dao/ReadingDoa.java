package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.Reading;

public interface ReadingDoa extends PagingAndSortingRepository<Reading, Long> {
}