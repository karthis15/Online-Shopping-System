package com.example.online_shopping.custom;

import org.hibernate.annotations.IdGeneratorType;

import com.example.online_shopping.hbm.generator.DefaultUsersIdGenerator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IdGeneratorType(DefaultUsersIdGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomUserId {
}
