package com.daniel.springshop.dto;

import com.daniel.springshop.domain.Product;
import com.daniel.springshop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDTO {
    private int amountProducts;
    private Double sum;
    private List<BucketDetailsDTO> bucketDetails =new ArrayList<>();

    public void aggregate(){
        this.amountProducts=bucketDetails.size();
        this.sum=bucketDetails.stream()
                .map(BucketDetailsDTO::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

}
