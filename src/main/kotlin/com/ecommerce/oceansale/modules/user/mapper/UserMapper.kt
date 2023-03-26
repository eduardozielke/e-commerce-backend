package com.ecommerce.oceansale.modules.user.mapper

import com.ecommerce.oceansale.modules.user.dto.UserDTO
import com.ecommerce.oceansale.modules.user.entity.User
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface UserMapper {

    fun toDto(entity: User): UserDTO

    fun toEntity(dto: UserDTO): User

    fun toDto(entity: List<User>): List<UserDTO>

    fun toEntity(dto: List<UserDTO>): List<User>


    companion object {
        var INSTANCE : UserMapper = Mappers.getMapper(UserMapper::class.java)
    }
}