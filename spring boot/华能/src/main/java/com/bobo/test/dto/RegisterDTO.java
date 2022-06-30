package com.bobo.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2021/9/4 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RegisterDTO {

    private Long id;
    private String name;
    private String password;
    private Integer departmentId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creatTime;
}
