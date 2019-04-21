package nz.fiore.service;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import nz.fiore.model.Gift;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;

@Singleton
@Traced
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    public void onMessage(@Observes Gift gift) {
        logger.info("EVENT: " + gift);
    }


    void onStart(@Observes StartupEvent ev) {               //
        logger.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {               //
        logger.info("The application is stopping...");
    }

}
