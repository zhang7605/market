package club.fangqcloud.mapper;

import club.fangqcloud.pojo.User;

import java.util.List;

public interface UserMapper {
    User selectByUserId(Integer userId);

    User selectByUsername(String username);

    List<User> selectDynatic(User user);

    int insertDynatic(User user);

}
