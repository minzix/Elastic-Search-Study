package study.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import study.elastic.domain.UserDocument;
import study.elastic.dto.UserCreateRequestDTO;
import study.elastic.dto.UserUpdateRequestDTO;
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
    public Page<UserDocument> findUsers() {
        return userDocumentRepository.findAll(PageRequest.of(0, 10));
    };

    @GetMapping("/{id}")
    public UserDocument findUserById(@PathVariable String id) {
        return userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않음."));
    }

    @PutMapping("/{id}")
    public UserDocument updateUser(@PathVariable String id, @RequestBody UserUpdateRequestDTO requestDTO) {
        UserDocument existingUser = userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않음."));
        existingUser.setName(requestDTO.getName());
        existingUser.setAge(requestDTO.getAge());
        existingUser.setIsActive(requestDTO.getIsActive());
        return userDocumentRepository.save(existingUser);
    };

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        UserDocument user = userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않음."));
        userDocumentRepository.delete(user);
    }
}
