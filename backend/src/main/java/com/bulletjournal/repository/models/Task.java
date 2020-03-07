package com.bulletjournal.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * This class is for ProjectType.TODO
 */
@Entity
@Table(name = "tasks",
        indexes = {@Index(name = "task_project_id_index", columnList = "project_id"),
            @Index(name = "task_assignee_interval_index", columnList = "assigned_to, start_time, end_time"),
            @Index(name = "task_assignee_reminder_date_time_index", columnList = "assigned_to, start_time, reminder_date_time")
        })
public class Task extends TaskModel {
    @Id
    @GeneratedValue(generator = "task_generator")
    @SequenceGenerator(
            name = "task_generator",
            sequenceName = "task_sequence",
            initialValue = 100
    )
    private Long id;

    public Long[] getLabels() {
        return labels;
    }

    public void setLabels(Long[] labels) {
        this.labels = labels;
    }

    @Type(type = "long-array")
    @Column(
            name = "labels",
            columnDefinition = "bigint[]"
    )
    private Long[] labels;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
