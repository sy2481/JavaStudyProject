import java.lang.reflect.Field;
import java.util.PriorityQueue;

/**
 * @Author sunyi
 * @Date: 2019/6/28
 */
public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.add("b");
        priorityQueue.add("c");
        priorityQueue.add("a");
        try {
            //System.out.println(priorityQueue.poll().getClass().equals(java.lang.Integer.class));
//            Class clazz=priorityQueue.poll().getClass();

            Field[] sField=PriorityQueue.class.getDeclaredFields();
            for (Field field : sField)
            {
                System.out.printf("Type：%-18s|",field.getType().getCanonicalName());
                //获取字段的类型的Type类对象，然后获取类的名字
                System.out.printf("GenericType:%-18s|",field.getGenericType().getTypeName());
                System.out.println(field.getName());

            }

        }catch (Exception e){}
        //System.out.println(priorityQueue.poll().getClass().equals(java.lang.String));
//        if(priorityQueue.poll().getClass());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll()); System.out.println(priorityQueue.poll());
    }
}
