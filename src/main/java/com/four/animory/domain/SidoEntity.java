package com.four.animory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "region_sido")
@org.hibernate.annotations.Immutable // 읽기 전용
@Getter
@NoArgsConstructor
public class SidoEntity {
    @Id
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;
}
