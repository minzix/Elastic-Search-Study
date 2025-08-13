package study.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.elastic.repository.UserDocumentRepository;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private UserDocumentRepository userDocumentRepository;


}
