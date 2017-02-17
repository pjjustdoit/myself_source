public class Test {
    public static void main(String[] args) {
        Foo foo = new FooProxy(new FooImp());
        foo.sayHello();
    }
}
