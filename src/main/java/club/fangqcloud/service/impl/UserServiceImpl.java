package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.UserMapper;
import club.fangqcloud.pojo.User;
import club.fangqcloud.service.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public JSON selectProfile(Integer userId) {
        JSONObject user = new JSONObject();
        user.put("username",userMapper.selectByUserId(userId).getUsername());
        user.put("auth",userMapper.selectByUserId(userId).getAuth());
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectDynatic(User user) {
        return userMapper.selectDynatic(user);
    }

    @Override
    public Boolean insertDynatic(User user) {
        if(userMapper.insertDynatic(user) > 0) {
            return true;
        }

        return false;
    }
}
