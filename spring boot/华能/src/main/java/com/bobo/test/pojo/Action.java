package com.bobo.test.pojo;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2021/9/9 23:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Action {
    private Long id;
    private Long conductor;
    private Long projectId;
    private LocalDateTime creatTime;
    private Integer rate;
}
