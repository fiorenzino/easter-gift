package nz.fiore.service;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.time.Instant;

@Singleton
@Traced
public class SimpleScheduler {
    private static final Logger logger = LoggerFactory.getLogger(SimpleScheduler.class);

    @Scheduled(every = "10s")
    void execute() {
        logger.info("timer: " + Instant.now());
    }
}
