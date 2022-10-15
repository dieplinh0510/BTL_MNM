package com.hit.base_1.adapter.web.v1.transfer.parameter.auth;

import com.hit.base_1.application.constants.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAuthenticationParameter {

    @NotBlank(message = UserMessageConstant.INVALID_GENERAL_NOT_BLANK)
    private String username;

    @NotBlank(message = UserMessageConstant.INVALID_GENERAL_NOT_BLANK)
    private String password;

}
