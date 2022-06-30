package com.bobo.test.vo;

import lombok.*;

/**
 * @Author admin
 * @create 2021/9/10 19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CountDepartmentVO {
    private String name;
    private Integer count;
}
