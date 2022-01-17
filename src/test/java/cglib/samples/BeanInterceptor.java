// package cglib.samples;

// import java.beans.PropertyChangeEvent;
// import java.beans.PropertyChangeListener;
// import java.beans.PropertyChangeSupport;
// import java.lang.reflect.Method;
// import java.lang.reflect.Modifier;

// import org.springframework.cglib.proxy.Enhancer;
// import org.springframework.cglib.proxy.MethodInterceptor;
// import org.springframework.cglib.proxy.MethodProxy;

// /**
//  * @author Chuck
//  * @since 12/31/2020
//  * @version
//  *
//  **/
// public class BeanInterceptor implements MethodInterceptor {
//     private PropertyChangeSupport sup;

//     public void addPropertyChangeListener(PropertyChangeListener listener) {
//         sup.addPropertyChangeListener(listener);
//     }

//     public void removePropertyChangeListener(PropertyChangeListener listener) {
//         sup.removePropertyChangeListener(listener);
//     }

//     /**
//      * 实例化
//      *
//      * @param clazz
//      * @return
//      */
//     public static Object newInstance(Class clazz) {
//         BeanInterceptor interceptor = new BeanInterceptor();
//         Enhancer eh = new Enhancer();
//         eh.setSuperclass(clazz);
//         eh.setCallback(interceptor);
//         Object bean = eh.create();
//         interceptor.sup = new PropertyChangeSupport(bean);
//         return bean;
//     }

//     /**
//      * 拦截
//      */
//     @Override
//     public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//         Object retValFromSuper = null;
//         try {
//             if (!Modifier.isAbstract(method.getModifiers())) {
//                 retValFromSuper = proxy.invoke(obj, args);
//             }
//         } finally {
//             String name = method.getName();
//             if (name.equals("addPropertyChangeListener")) {
//                 addPropertyChangeListener((PropertyChangeListener) args[0]);
//             } else if (name.equals("removePropertyChangeListener")) {
//                 removePropertyChangeListener((PropertyChangeListener) args[0]);
//             } else if (name.startsWith("set") && args.length == 1 && method.getReturnType() == Void.TYPE) {
//                 char[] propName = name.substring("set".length()).toCharArray();
//                 propName[0] = Character.toLowerCase(propName[0]);
//                 sup.firePropertyChange(new String(propName), null, args[0]);
//             }
//         }
//         return retValFromSuper;
//     }

//     public static void main(String[] args) {
//         Bean bean = (Bean) newInstance(Bean.class);
//         bean.addPropertyChangeListener(new PropertyChangeListener() {

//             @Override
//             public void propertyChange(PropertyChangeEvent evt) {
//                 System.out.println(evt);
//             }
//         });
//     }
// }