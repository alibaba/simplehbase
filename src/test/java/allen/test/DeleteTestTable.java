package allen.test;

/**
 * @author xinzhi
 * */
public class DeleteTestTable {

    public static void main(String[] args) {
        try {
            Config.deleteTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
