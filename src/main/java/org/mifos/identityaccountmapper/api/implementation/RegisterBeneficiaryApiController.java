package org.mifos.identityaccountmapper.api.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.identityaccountmapper.data.RequestDTO;
import org.mifos.identityaccountmapper.data.ResponseDTO;
import org.mifos.identityaccountmapper.service.RegisterBeneficiaryService;
import org.mifos.identityaccountmapper.api.definition.RegisterBeneficiaryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import static org.mifos.identityaccountmapper.util.AccountMapperEnum.*;

@RestController
public class RegisterBeneficiaryApiController implements RegisterBeneficiaryApi {
    @Autowired
    RegisterBeneficiaryService registerBeneficiaryService;

    @Override
    public ResponseDTO registerBeneficiary(String callbackURL, RequestDTO requestBody) throws ExecutionException, InterruptedException, JsonProcessingException {
        try {
            registerBeneficiaryService.registerBeneficiary(callbackURL, requestBody);
        }catch (Exception e){
            return new ResponseDTO(FAILED_RESPONSE_CODE.getValue(), FAILED_RESPONSE_MESSAGE.getValue(), requestBody.getRequestID());

        }
        return new ResponseDTO(SUCCESS_RESPONSE_CODE.getValue(), SUCCESS_RESPONSE_MESSAGE.getValue(), requestBody.getRequestID());
    }
}
