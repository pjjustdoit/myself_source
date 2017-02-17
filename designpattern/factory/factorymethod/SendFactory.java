/**
 * 多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class SendFactory {
    public Sender productMail() {
        return new MailSender();
    }
    public Sender productSms() {
        return new SmsSender();
    }
}
