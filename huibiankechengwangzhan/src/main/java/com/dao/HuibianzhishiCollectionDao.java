package com.dao;

import com.entity.HuibianzhishiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuibianzhishiCollectionView;

/**
 * 汇编知识收藏 Dao 接口
 *
 * @author 
 */
public interface HuibianzhishiCollectionDao extends BaseMapper<HuibianzhishiCollectionEntity> {

   List<HuibianzhishiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
