package study.elastic.dto;

import lombok.Getter;

@Getter
public class UserCreateRequestDTO {
    private String id;
    private String name;
    private Long age;
    private Boolean isActive;
}
