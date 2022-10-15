package com.hit.base_1.application.output;

import com.hit.base_1.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserDataOutput {

    private List<User> data;
    private String message;

}
