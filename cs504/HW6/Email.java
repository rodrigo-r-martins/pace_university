public class Email {

    private String emailStr;

    Email() {}

    Email(String emailStr) {
        this.emailStr = emailStr;
    }

    public String parseEmailName() {
        String name;
        int pos = emailStr.indexOf('@');
        name = emailStr.substring(0, pos);
        return name;
    }

    public String parseCompanyName() {
        String company;
        int pos = emailStr.indexOf('@');
        int dot = emailStr.lastIndexOf('.');
        company = emailStr.substring(pos+1, dot);
        return company;
    }

    public String parseExtension() {
        String ext;
        int dot = emailStr.lastIndexOf('.');
        ext = emailStr.substring(dot+1, emailStr.length());
        return ext;
    }
}
