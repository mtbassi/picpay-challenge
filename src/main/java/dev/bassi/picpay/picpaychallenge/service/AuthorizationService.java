package dev.bassi.picpay.picpaychallenge.service;

import dev.bassi.picpay.picpaychallenge.client.AuthorizationClient;
import dev.bassi.picpay.picpaychallenge.exception.PicPayException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public Boolean isAuthorized(){
        var response = this.authorizationClient.isAuthorized();
        if (response.getStatusCode().isError()){
            throw new PicPayException();
        }
        return Objects.requireNonNull(response.getBody()).isAuthorized();
    }
}
