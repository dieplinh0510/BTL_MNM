package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.adapter.web.v1.transfer.parameter.user.GetListUserParameter;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.input.CreateUserDataInput;
import com.hit.base_1.application.input.GetAllUserDataInput;
import com.hit.base_1.application.input.GetUserByIdDataInput;
import com.hit.base_1.application.mapper.UserMapper;
import com.hit.base_1.application.output.GetListUserDataOutput;
import com.hit.base_1.application.output.GetUserDataOutput;
import com.hit.base_1.application.service.UserService;
import com.hit.base_1.domain.dto.UserDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiV1
public class UserController {

  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(UrlConstant.User.GET_USER_DATA)
  public ResponseEntity<?> getAllUser(@Valid GetListUserParameter parameter) {
    //create input
    GetAllUserDataInput input = new GetAllUserDataInput(parameter.getPage());

    //Get output
    GetListUserDataOutput output = userService.getAllUser(input);

    //Return output
    return VsResponseUtil.ok(output);
  }

  // Lấy thông tin của 1 user
  @GetMapping(UrlConstant.User.GET_USER_ID_DATA)
  public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
    GetUserByIdDataInput input = new GetUserByIdDataInput(id);

    GetUserDataOutput output = userService.getUserById(input);

    return VsResponseUtil.ok(output);
  }

  @PostMapping(UrlConstant.User.CREATE_USER)
  public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
    CreateUserDataInput input = userMapper.userDTOToCreateUserDataInput(userDTO);

    GetUserDataOutput output = userService.creatUser(input);

    return VsResponseUtil.ok(output);
  }

  // Lấy thông tin user đang login
  @GetMapping(UrlConstant.User.CURRENT_LOGIN)
  public ResponseEntity<?> getUserLogin() {
    return VsResponseUtil.ok(userService.getUserLogin());
  }

}
