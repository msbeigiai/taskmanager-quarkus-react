package org.msbeigi.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tasks")
public class Task extends PanacheEntity {

  @Column(nullable = false)
  public String title;

  @Column(length = 1000)
  public String description;

  public Integer priority;

  @ManyToOne(optional = false)
  public User user;

  public ZonedDateTime complete;

  @ManyToOne
  public Project project;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  public ZonedDateTime created;

  @Version
  public int version;
}