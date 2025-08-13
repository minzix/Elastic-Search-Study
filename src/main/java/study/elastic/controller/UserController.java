package study.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.elastic.domain.UserDocument;
import study.elastic.repository.UserDocumentRepository;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private UserDocumentRepository userDocumentRepository;


}
