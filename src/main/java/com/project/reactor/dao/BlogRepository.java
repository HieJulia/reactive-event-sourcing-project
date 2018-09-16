package com.project.reactor.dao;


import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


public interface BlogRepository extends CrudRepository<BlogPost, UUID> {
}