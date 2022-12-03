package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.constants.CommonConstant;
import com.hit.base_1.application.constants.DevMessageConstant;
import com.hit.base_1.application.constants.UserMessageConstant;
import com.hit.base_1.application.dai.StudentRepository;
import com.hit.base_1.application.dai.UserRepository;
import com.hit.base_1.application.input.CreateUserDataInput;
import com.hit.base_1.application.input.GetAllUserDataInput;
import com.hit.base_1.application.input.GetUserByIdDataInput;
import com.hit.base_1.application.mapper.UserMapper;
import com.hit.base_1.application.output.GetCurrentUserLoginOutput;
import com.hit.base_1.application.output.GetListUserDataOutput;
import com.hit.base_1.application.output.GetUserDataOutput;
import com.hit.base_1.application.service.UserService;
import com.hit.base_1.application.utils.SecurityUtil;
import com.hit.base_1.config.exception.VsException;
import com.hit.base_1.domain.entity.Student;
import com.hit.base_1.domain.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIml implements UserService {

  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
  private final UserRepository userRepository;
  private final StudentRepository studentRepository;

  public UserServiceIml(UserRepository userRepository, StudentRepository studentRepository) {
    this.userRepository = userRepository;
    this.studentRepository = studentRepository;
  }

  private User checkUserExists(Optional<User> user) {
    if (user.isEmpty()) {
      throw new VsException(HttpStatus.NOT_FOUND, UserMessageConstant.NO_DATA_SELECT_RESULT,
          DevMessageConstant.User.NO_DATA_USER_ID);
    }
    return user.get();
  }

  @Override
  public GetListUserDataOutput getAllUser(GetAllUserDataInput input) {
    List<User> users = userRepository.findAll(PageRequest.of(input.getPage(), CommonConstant.SIZE_OF_PAGE.intValue()))
        .getContent();
    if (CollectionUtils.isEmpty(users)) {
      throw new VsException(HttpStatus.NO_CONTENT, UserMessageConstant.NO_DATA_SELECT_RESULT,
          DevMessageConstant.User.NO_DATA_USER);
    }
    return new GetListUserDataOutput(users, CommonConstant.EMPTY_MESSAGE);
  }

  @Override
  public GetUserDataOutput getUserById(GetUserByIdDataInput input) {
    return new GetUserDataOutput(checkUserExists(userRepository.findById(input.getId())));
  }

  @Override
  public GetUserDataOutput creatUser(CreateUserDataInput input) {
    //check gì ở đây thì check nhé :v
    return new GetUserDataOutput(userRepository.save(userMapper.createUserDataInputToUser(input)));
  }

  @Override
  public GetCurrentUserLoginOutput getUserLogin() {
    String id = SecurityUtil.getCurrentUserLogin();
    try {
      Long.parseLong(id);
    } catch (Exception ex) {
      return null;
    }
    Student user = studentRepository.findById(Long.parseLong(id)).get();
    return new GetCurrentUserLoginOutput(user.getStudentId(), user.getFullName(), user.getAvatar(),
        user.getStudentOfClass(), user.getMajor(), user.getDateOfBirth());
  }

}
