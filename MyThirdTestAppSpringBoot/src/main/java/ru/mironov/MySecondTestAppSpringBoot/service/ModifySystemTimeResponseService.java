package ru.mironov.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Response;
import ru.mironov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Slf4j
@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        log.info("modify response: {}", response);
        return response;
    }
}

