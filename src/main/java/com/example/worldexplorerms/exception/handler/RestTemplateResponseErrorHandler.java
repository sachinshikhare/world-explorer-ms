package com.example.worldexplorerms.exception.handler;

import com.example.worldexplorerms.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().is4xxClientError()
                        || clientHttpResponse.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode().is4xxClientError()
                && clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND
        ) {
                throw new ResourceNotFoundException("Data not found");
        }
    }
}
