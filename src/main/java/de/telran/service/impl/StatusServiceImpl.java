package de.telran.service.impl;

import de.telran.model.entity.Status;
import de.telran.repository.StatusRepository;
import de.telran.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }
}
