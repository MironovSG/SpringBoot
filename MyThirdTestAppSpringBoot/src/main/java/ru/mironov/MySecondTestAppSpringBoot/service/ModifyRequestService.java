package ru.mironov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Request;
@Service
public interface ModifyRequestService {
    void modify(Request request);
}
