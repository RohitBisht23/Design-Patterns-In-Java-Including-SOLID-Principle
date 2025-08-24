class SimpleNotification implements INotification {
    private String content;

    public SimpleNotification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}