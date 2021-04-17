
package jvm.frontcompile;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * @author Chuck
 * @since 3/25/2021
 * @version 0.0.1
 *
 **/
// 标注对哪些注解感兴趣，*表示对所有Annotation感兴趣
// @SupportedAnnotationTypes("*")
// 处理器可以处理哪些版本的Java代码，只支持jdk8的代码
// @SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {
    private NameChecker nameChecker;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
     * annotations: 此处理器要处理的注解集合
     *
     * roundEnv: 当前Round中的AST节点（Element）。
     *
     * 包括18类Element，如package、enum、class、annotation_type、interface、enum_constant、field、parameter、local_variable。。。。
     *
     * 返回false表示没有改变AST，无需构造新的JavaCompiler
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // processingEnv变量在注解处理器初始化的时候创建，
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkNames(element);
            }
        }
        return false;
    }

}
