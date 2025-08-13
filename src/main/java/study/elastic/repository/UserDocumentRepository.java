package study.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import study.elastic.domain.UserDocument;

public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {

}
