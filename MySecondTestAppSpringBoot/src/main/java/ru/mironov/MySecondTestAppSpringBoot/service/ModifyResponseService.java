package ru.mironov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
