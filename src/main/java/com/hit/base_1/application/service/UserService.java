package com.hit.base_1.application.service;

import com.hit.base_1.application.input.CreateUserDataInput;
import com.hit.base_1.application.input.GetAllUserDataInput;
import com.hit.base_1.application.input.GetUserByIdDataInput;
import com.hit.base_1.application.output.GetListUserDataOutput;
import com.hit.base_1.application.output.GetUserDataOutput;

public interface UserService {

  GetListUserDataOutput getAllUser(GetAllUserDataInput input);

  GetUserDataOutput getUserById(GetUserByIdDataInput input);

  GetUserDataOutput creatUser(CreateUserDataInput input);

}
