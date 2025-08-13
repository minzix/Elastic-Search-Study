package study.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import study.elastic.domain.UserDocument;
import study.elastic.dto.UserCreateRequestDTO;
import study.elastic.repository.UserDocumentRepository;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserDocumentRepository userDocumentRepository;

    @PostMapping
    public UserDocument createUser(@RequestBody UserCreateRequestDTO requestDTO) {
        UserDocument user = new UserDocument(
                requestDTO.getId(),
                requestDTO.getName(),
                requestDTO.getAge(),
                requestDTO.getIsActive()
        );
        return userDocumentRepository.save(user);
    };

    @GetMapping
    public Page<UserDocument> getUsers() {
        return userDocumentRepository.findAll(PageRequest.of(0, 10));
    };
}
