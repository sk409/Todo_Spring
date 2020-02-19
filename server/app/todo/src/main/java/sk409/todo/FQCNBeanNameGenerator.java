package sk409.todo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class FQCNBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String buildDefaultBeanName(BeanDefinition beanDefinition) {
        return beanDefinition.getBeanClassName();
    }

}