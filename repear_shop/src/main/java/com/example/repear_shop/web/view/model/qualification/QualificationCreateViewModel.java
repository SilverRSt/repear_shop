package com.example.repear_shop.web.view.model.qualification;

import com.example.repear_shop.data.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QualificationCreateViewModel {
    @NotBlank
    private String qualification;

    private List<Employee> employees;
}
