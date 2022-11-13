package com.example.repear_shop.web.view.model.qualification;

import com.example.repear_shop.data.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QualificationViewModel {
    private Long qualificationId;
    private String qualification;
    private List<Employee> employees;
}
