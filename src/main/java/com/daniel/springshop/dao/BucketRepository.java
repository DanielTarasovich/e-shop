package com.daniel.springshop.dao;

import com.daniel.springshop.domain.Bucket;
import com.daniel.springshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket, Long> {



}
