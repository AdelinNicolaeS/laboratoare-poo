package Task2;


public class Test {
    public static void main(String[] args) {
        Task2.PasswordMaker maker1 = PasswordMaker.getInstance(); // apel static
        maker1.setName("Maria");
        System.out.println(maker1.getMAGIC_NUMBER());
        System.out.println(maker1.getMAGIC_STRING());
        System.out.println(maker1.getName());
        System.out.println(maker1.getPassword());

        Task2.PasswordMaker maker2 = PasswordMaker.getInstance(); // apel static
        maker2.setName("Ion");
        System.out.println(maker2.getMAGIC_NUMBER());
        System.out.println(maker2.getMAGIC_STRING());
        System.out.println(maker2.getName());
        System.out.println(maker2.getPassword());

        System.out.println(maker1.getName()); // e o singura instanta, deci va afisa Ion, nu Maria

        System.out.println(PasswordMaker.getInstanceCount()); // 2 apeluri
    }
}
