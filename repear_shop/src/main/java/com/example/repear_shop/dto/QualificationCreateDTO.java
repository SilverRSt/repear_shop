package com.example.repear_shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QualificationCreateDTO {
    private Long qualificationId;
    private String qualification;
}
