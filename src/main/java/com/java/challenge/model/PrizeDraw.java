package com.java.challenge.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class PrizeDraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime lastPrize;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package pack;

}
