package com.hit.base_1.domain.entity;

import com.hit.base_1.application.constants.TableNameConstant;
import com.hit.base_1.application.constants.UserMessageConstant;
import com.hit.base_1.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNameConstant.TABLE_USER)
public class User extends AbstractAuditingEntity {

    @Column(unique = true)
    @NotBlank(message = UserMessageConstant.EXCEPTION_GENERAL_REQUIRED)
    private String username;

    @NotBlank(message = UserMessageConstant.EXCEPTION_GENERAL_REQUIRED)
    private String password;

}
