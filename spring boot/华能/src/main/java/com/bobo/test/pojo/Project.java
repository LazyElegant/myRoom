package com.bobo.test.pojo;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2021/9/8 20:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Project {

    private Long id;
    private String title;
    private String content;
    private Long submitterId;
    private Integer checkDepartment;
    private Integer conductDepartment;
    private LocalDateTime creatTime;
    private Integer rate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer priority;

}
