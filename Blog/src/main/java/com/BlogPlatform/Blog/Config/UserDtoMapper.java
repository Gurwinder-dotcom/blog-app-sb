package com.BlogPlatform.Blog.Config;


import com.BlogPlatform.Blog.Entity.User;
import com.BlogPlatform.Blog.Payloads.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {


    public User fromDto(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto toDto(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
