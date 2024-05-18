package ir.barook.barokinterview.repository;

import ir.barook.barokinterview.model.UserLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserLogRepository extends ElasticsearchRepository<UserLog, Integer> {
}
