package info.mintymods.mss.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.mss.webapp.domain.AccessHistory;
import info.mintymods.mss.webapp.repository.AccessHistoryRepository;
import info.mintymods.mss.webapp.service.AccessHistoryService;

@Service
@Qualifier("userDetailsService")
public class AccessHistoryServiceImpl implements AccessHistoryService {

	@Autowired
	private AccessHistoryRepository accessHistoryRepository;

	@Override
	public AccessHistory insert(AccessHistory accessHistory) {
		return accessHistoryRepository.save(accessHistory);
	}
}
