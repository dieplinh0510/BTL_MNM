package com.hit.base_1.adapter.web.v1.transfer.parameter.user;

import com.hit.base_1.application.constants.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserParameter {

    @Min(value = 0, message = UserMessageConstant.INVALID_DATA_PAGE_MIN)
    private Integer page;

}
