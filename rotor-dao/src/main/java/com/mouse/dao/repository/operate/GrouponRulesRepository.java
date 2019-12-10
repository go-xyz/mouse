package com.mouse.dao.repository.operate;

import com.mouse.dao.entity.operate.GrouponRulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ; lidongdong
 * @Description
 * @Date 2019-11-26
 */
@Repository
public interface GrouponRulesRepository extends JpaRepository<GrouponRulesEntity, Integer>, JpaSpecificationExecutor<GrouponRulesEntity> {


}