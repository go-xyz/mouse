package com.mouse.api.service.impl;

import com.mouse.api.service.BrandService;
import com.mouse.dao.entity.resource.BrandEntity;
import com.mouse.dao.repository.resource.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

/**
 * @author ; lidongdong
 * @Description 品牌商表
 * @Date 2019-12-15
 */
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;

    @Override
    public Optional<BrandEntity> findById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Page<BrandEntity> findPage(Integer pageNum, Integer pageSize) {
        Page<BrandEntity> page = brandRepository.findAll((Specification<BrandEntity>) (root, criteriaQuery, criteriaBuilder) -> {

            Predicate predicate = criteriaBuilder.conjunction();
            List<Expression<Boolean>> expressions = predicate.getExpressions();
            expressions.add(criteriaBuilder.equal(root.<Boolean>get("deleted"), false));

            return predicate;
        }, PageRequest.of(pageNum, pageSize, new Sort(Sort.Direction.DESC, "id")));

        return page;
    }

    @Override
    public List<BrandEntity> findByGoodsId(Integer brandId) {
        List<BrandEntity> brandEntities = brandRepository.findAll((Specification<BrandEntity>) (root, criteriaQuery, criteriaBuilder) -> {

            Predicate predicate = criteriaBuilder.conjunction();
            List<Expression<Boolean>> expressions = predicate.getExpressions();
            expressions.add(criteriaBuilder.equal(root.<Integer>get("id"), brandId));
            expressions.add(criteriaBuilder.equal(root.<Boolean>get("deleted"), false));

            return predicate;
        }, new Sort(Sort.Direction.DESC, "id"));

        return brandEntities;
    }
}
