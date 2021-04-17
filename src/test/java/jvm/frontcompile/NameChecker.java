
package jvm.frontcompile;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic.Kind;

/**
 *
 * Usage：通过javac命令的-processor指定注解处理器，还可以使用-XprintRounds和-XprintProcessorInfo查看注解处理器运作的详细信息
 *
 * @author Chuck
 * @since 2021年3月25日
 * @version 0.0.1
 *
 *
 */

public class NameChecker {

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    /**
     * VisitXXX的命名方式说明使用了Vistor模式
     *
     * @author Chuck
     * @since 2021年3月25日
     * @version 0.0.1
     *
     *
     */
    private class NameCheckScanner extends ElementScanner8<Void, Void> {
        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }

        public Void visitExecutable(ExecutableElement e, Void p) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Kind.WARNING, "一个普通方法：" + name + "，不应当与类名重复，避免与构造函数产生歧义");
                }
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, p);
            return null;
        }

        public Void visitVariable(VariableElement e, Void p) {
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }
            return null;
        }

        /**
         * 判断一个变量是否为常量
         *
         * @param e
         * @return
         */
        private boolean heuristicallyConstant(VariableElement e) {
            // TODO
            return Boolean.FALSE;
        }

        /**
         * 判断Element是否符合驼峰命名，不符合输出警告信息
         *
         * @param e
         * @param initialCaps
         */
        private void checkCamelCase(Element e, boolean initialCaps) {
            // TODO
        }

        /**
         * 大写命名检查，第一个字母必须是大写
         *
         * @param e
         */
        private void checkAllCaps(Element e) {
            // TODO
        }
    }
}
