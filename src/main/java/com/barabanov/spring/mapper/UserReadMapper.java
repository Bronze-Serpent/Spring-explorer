package com.barabanov.spring.mapper;

import com.barabanov.spring.database.entity.User;
import com.barabanov.spring.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto>
{

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object)
    {
        var company = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);

        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getRole(),
                company
        );
    }
}
