package com.apress.isf.spring.scheduler;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by nishi on 2016-04-17.
 */
@Component
public class DocumentScheduler {
    private static Logger log = LoggerFactory.getLogger(DocumentScheduler.class);
    private static int HTTP_NOT_FOUND_CODE = 404;
    private static int HTTP_OK_CODE = 200;

//    @Scheduled(fixedRate = 3000)
    public void sampleCronMethod() {
        log.debug("Wywoływana co trzy sekundy...");
    }


    @Autowired
    DocumentService documentService;

    private Type webType = new Type("WEB", ".url");

//    @Scheduled(cron = "*/10 * * * * ?")
    public void urlCheck() throws IOException {
        log.debug("@@ Sprawdzanie adresu URL dokumentu typu sieciowego...");
        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;
        List<Document> documents = documentService.findByType(webType);
        for(Document document: documents) {
            url = new URL(document.getLocation());
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
                connection.connect();
                responseCode = connection.getResponseCode();
                log.debug("Szukanie nazwy: " + document.getName());
                log.debug("Kod: " + Integer.toString(responseCode));
                if(HTTP_OK_CODE == responseCode)
                    log.info("URL jest poprawny!!");
                else
                    log.error("Niepoprawny URL! Kod: " + HTTP_NOT_FOUND_CODE + ". Poinformuj administratora.");
        }
    }
}
