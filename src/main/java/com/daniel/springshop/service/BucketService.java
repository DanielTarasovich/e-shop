package com.daniel.springshop.service;

import com.daniel.springshop.domain.Bucket;
import com.daniel.springshop.domain.User;
import com.daniel.springshop.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);


    BucketDTO getBucketByUser(String name);


}
