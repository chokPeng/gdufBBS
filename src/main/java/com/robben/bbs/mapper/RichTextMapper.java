package com.robben.bbs.mapper;import org.springframework.stereotype.Repository;@Repositorypublic interface RichTextMapper {    Integer saveRichText(Long authorId,String content);    String getRichTextById(Integer id);}