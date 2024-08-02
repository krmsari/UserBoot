package com.kerem.userboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor  /*jwt için üçüncü aşama*/
public class AuthRequest {
    private String userName;
    private String password;
}
