package com.example.demo.web;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * 2020/4/1
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
public class TestMessageConverter implements HttpMessageConverter {


    @Override
    public boolean canRead(Class aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    @Override
    public Object read(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }


}
