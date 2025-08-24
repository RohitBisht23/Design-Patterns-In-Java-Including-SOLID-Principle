//Decorator to add Singnature to the content
class SignatureDecorator implements INotificationDecorator {
    protected INotification wrappee;

    public SignatureDecorator(INotification wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getContent() {
        return wrappee.getContent() + " [Signature: CompanyXYZ]";
    }
}