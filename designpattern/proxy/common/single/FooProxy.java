public class FooProxy implements Foo {
    private Foo foo;
    public FooProxy(Foo foo) {
        this.foo = foo;
    }
    public void sayHelloBefore() {
        System.out.println("before");
    }
    public void sayHelloAfter() {
        System.out.println("atfer");
    }
    public void sayHello() {
        sayHelloBefore();
        foo.sayHello();
        sayHelloAfter();
    }
}
