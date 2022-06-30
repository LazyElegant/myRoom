package com.bobo.test.dto;

import lombok.*;

/**
 * @Author wjb
 * @create 2021/9/4 14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class LoginDTO {
    private Long id;
    private String password;
}
