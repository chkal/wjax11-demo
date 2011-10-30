package de.chkal.wjax11.service;

import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.io.IOUtils;

@ApplicationScoped
public class BookImageService {

    public byte[] getBookImage(Long isbn) {
        
        String resource = "images/" + isbn + ".jpg";
        
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);

        if (stream == null) {
            return null;
        }

        try {
            return IOUtils.toByteArray(stream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
