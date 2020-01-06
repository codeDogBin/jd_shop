package com.bin.mapper;

import com.bin.bean.JdCategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JdCategoryDao {
    @Select("select * from jd_category where parent_id = #{parent_id}")
    List<JdCategory> FindSubCategoriesByParentId(int parent_id);


}
