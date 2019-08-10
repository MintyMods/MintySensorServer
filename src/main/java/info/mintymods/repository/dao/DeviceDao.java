package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.Device;

public interface DeviceDao extends PagingAndSortingRepository<Device, Long> {
}