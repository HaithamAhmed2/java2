package org.example.model;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    private Long id;

    private String title;

}
