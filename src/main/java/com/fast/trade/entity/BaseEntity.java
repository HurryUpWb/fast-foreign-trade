package com.fast.trade.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @title: BaseEntity
 * @package com.fast.trade.entity
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 9:35
 * @version: V1.0
 */
@MappedSuperclass
public class BaseEntity {

    @Column(insertable = false, updatable = false)
    private Date createTime;

    @Column(insertable = false, updatable = false)
    private Date modifyTime;



    public Date getCreateTime() {

        return createTime;
    }



    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }



    public Date getModifyTime() {

        return modifyTime;
    }



    public void setModifyTime(Date modifyTime) {

        this.modifyTime = modifyTime;
    }
}
