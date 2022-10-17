package com.hit.base_1.application.mapper;

import com.hit.base_1.application.input.CreateUserDataInput;
import com.hit.base_1.domain.dto.UserDTO;
import com.hit.base_1.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "username", source = "userDTO.username"),
            @Mapping(target = "password", source = "userDTO.password")
    })
    CreateUserDataInput userDTOToCreateUserDataInput(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "username", source = "input.username"),
            @Mapping(target = "password", source = "input.password")
    })
    User createUserDataInputToUser(CreateUserDataInput input);



}
