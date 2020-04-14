package com.yinjune.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * banner表
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_banner")
public class Banner extends Model<Banner> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * banner名称
     */
    private String name;

    /**
     * banner位置（index_top:首页顶部;category_top:分类顶部）
     */
    private String position;

    /**
     * banner图的url
     */
    private String bannerUrl;

    /**
     * banner跳转url
     */
    private String redirectUrl;

    /**
     * 跳转类型（1：内部跳转，2：外部跳转h5）
     */
    private String redirectType;

    /**
     * 状态（1：正常，2：失效，3：删除）
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
