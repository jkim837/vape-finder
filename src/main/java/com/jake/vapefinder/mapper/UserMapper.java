package com.jake.vapefinder.mapper;

import org.mapstruct.Mapper;

import com.jake.vapefinder.dto.UserDTO;
import com.jake.vapefinder.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}