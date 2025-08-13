package study.elastic.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDTO {
    private String name;
    private Long age;
    private Boolean isActive;
}
