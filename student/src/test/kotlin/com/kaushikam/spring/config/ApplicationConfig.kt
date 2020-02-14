package com.kaushikam.spring.config

import com.kaushikam.application.impl.StudentManagementServiceImpl
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [StudentManagementServiceImpl::class])
class ApplicationConfig