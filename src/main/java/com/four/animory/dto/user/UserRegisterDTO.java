package com.four.animory.dto.user;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private MemberDTO member;
    private PetDTO pet;
}
