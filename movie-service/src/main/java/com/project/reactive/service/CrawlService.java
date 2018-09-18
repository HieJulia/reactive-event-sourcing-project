
import reactor.core.publisher.Flux;

public interface CrawlService {
    Flux<String> getCrawl();
}

