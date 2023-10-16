package ru.mironov.MySecondTestAppSpringBoot.service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Request;
@Service
@Qualifier("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request){
        request.setSource("From Service 1");
    }
}
