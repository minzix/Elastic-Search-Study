package study.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.elastic.domain.UserDocument;
import study.elastic.dto.UserCreateRequestDTO;
import study.elastic.repository.UserDocumentRepository;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private UserDocumentRepository userDocumentRepository;

    @PostMapping
    public UserDocument createUser(@RequestBody UserCreateRequestDTO requestDTO) {
        UserDocument user = new UserDocument(
                requestDTO.getId(),
                requestDTO.getName(),
                requestDTO.getAge(),
                requestDTO.getIsActive()
        );
        return userDocumentRepository.save(user);
    }
}
