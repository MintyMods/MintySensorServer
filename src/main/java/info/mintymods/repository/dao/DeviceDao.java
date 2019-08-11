package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Device;

@Repository
public interface DeviceDao extends PagingAndSortingRepository<Device, Long> {
}