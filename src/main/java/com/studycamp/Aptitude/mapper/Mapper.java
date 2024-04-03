package com.studycamp.Aptitude.mapper;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Tag;

public interface Mapper <A,B>{
     A mapTo (B b , Category category);
     B mapFrom(A a);
}
