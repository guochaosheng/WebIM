package org.webim.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @ClassName MyBatisAnnotation
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-2 下午9:01:08
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBatisAnnotation {
}
