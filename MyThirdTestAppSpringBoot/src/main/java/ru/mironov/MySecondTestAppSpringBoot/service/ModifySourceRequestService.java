package ru.mironov.MySecondTestAppSpringBoot.service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Request;
@Primary
@Service
@Qualifier("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request) {
        request.setSource("Новое значение для source");
    }
}
