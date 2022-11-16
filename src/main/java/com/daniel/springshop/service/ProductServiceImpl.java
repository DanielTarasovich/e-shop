package com.daniel.springshop.service;


import com.daniel.springshop.dao.ProductRepository;
import com.daniel.springshop.dao.UserRepository;
import com.daniel.springshop.domain.Bucket;
import com.daniel.springshop.domain.User;
import com.daniel.springshop.dto.ProductDTO;
import com.daniel.springshop.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper mapper = ProductMapper.MAPPER;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, BucketService bucketService) {
        this.userService = userService;
        this.bucketService = bucketService;
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDTO> getAll() {
return mapper.fromProductList(productRepository.findAll());
    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);

        if (user == null) {
            throw new RuntimeException("This user was not found");
        }
        Bucket bucket = user.getBucket();
        if (bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);

    }else {
            bucketService.addProducts(bucket, Collections.singletonList(productId));
        }


    }
}
