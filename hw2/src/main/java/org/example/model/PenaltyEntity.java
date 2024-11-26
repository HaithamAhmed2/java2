package org.example.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyEntity {

    private Long id;

    private Long carId;

    private Integer amount;

    private Date dayTime;

}
