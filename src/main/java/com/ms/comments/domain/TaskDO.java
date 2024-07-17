package com.ms.comments.domain;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder

public class TaskDO {

        private Long id;
        private String name;
        private String description;
        private boolean state;
        private String priority;
}
