package com.kaushikam.spring.config

import com.kaushikam.infrastructure.repository.hibernate.HibernateStudentRepository
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = [HibernateStudentRepository::class])
class PersistenceConfig