package 数据结构;

/**
 * 数组类，无序数组
 */
public class Array {
    private String[] strArray;
    private int length = 0;  //数组长度

    //构造函数
    public Array(int max) {
        strArray = new String [max];
    }

    //检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
    public int contains(String target) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (strArray[i].equals(target))
                index = i;
            return index;
        }
        return index;
    }

    //插入方法
   public void add(String elem) {
        strArray[length] = elem;
        length++;
    }

    //删除指定值,成功返回true,失败返回false
    public boolean delete(String target) {
        if (contains(target) != -1) {
            int index = contains(target);
            for (int i = index; i < length - 1; i++) {
                //删除元素之后的所有元素前移一位
                strArray[i] = strArray[i + 1];
            }
            length--;
            return true;
        } else {
            return false;
        }
    }

    //列出所有元素
    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(strArray[i] + "\t");
        }
    }

    public static void main(String []args){
        Array array = new Array(5);
        array.add("apple");
        array.add("baranana");
        System.out.println("是否存在Apple:"+array.contains("apple"));
        array.display();

    }
}
