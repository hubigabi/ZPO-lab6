import annotation.Scheduled;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        for (String arg : args) {
            try {
                Class aClass = Class.forName(arg);
                Object object = aClass.newInstance();

                for (Method method : aClass.getDeclaredMethods()) {
                    method.setAccessible(true);
                    if (method.isAnnotationPresent(Scheduled.class)
                            && method.getParameterCount() == 0) {
                        Scheduled scheduled = method.getAnnotation(Scheduled.class);

                        TimerTask task = new TimerTask() {
                            public void run() {
                                try {
                                    method.invoke(object);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        Timer timer = new Timer();
                        timer.schedule(task, 0, scheduled.period());
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }
}